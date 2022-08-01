package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.publishing.event.AdvertStatusUpdatedMessage;
import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.usecase.CreateAdvertUseCase;
import com.emlakjet.publishing.usecase.UpdateAdvertStatusUseCase;
import com.emlakjet.advert.usecase.UpdateAdvertUseCase;
import com.emlakjet.approval.enums.ApprovalStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertAdapter implements AdvertPort {

    private final KafkaTemplate<String, Object> advertEventSender;

    private static final String ADVERT_CREATED = "advert-created";

    private static final String ADVERT_UPDATED = "advert-updated";

    private static final String ADVERT_DELETED = "advert-deleted";

    private final AdvertRepository advertRepository;

    private final AdvertMapper mapper;

    @Override
    public Advert createAdvert(CreateAdvertUseCase advert) {

        var createdAdvert = advertRepository.save(
                mapper.toAdvertEntity(advert)
                        .toBuilder()
                        .approvalStatus(ApprovalStatus.REQUESTED)
                        .advertStatus(AdvertStatus.HANG)
                        .build());

        advertEventSender.send(ADVERT_CREATED, mapper.toAdvertCreatedMessage(createdAdvert));

        return mapper.toAdvert(createdAdvert);
    }

    @Override
    public Advert updateAdvert(UpdateAdvertUseCase advert) {

        var updatedAdvert = advertRepository.findById(advert.advertId())
                .map(oldEntity -> mapper.toAdvertEntity(oldEntity, advert))
                .orElseThrow(AdvertNotFoundException::new);

        advertEventSender.send(ADVERT_UPDATED, mapper.toAdvertUpdatedMessage(updatedAdvert));

        return mapper.toAdvert(updatedAdvert);
    }

    @Override
    public void deleteAdvert(Long advertId) {

        advertRepository.deleteById(advertId);

        advertEventSender.send(ADVERT_DELETED, mapper.toAdvertDeletedMessage(advertId));

    }

    @Override
    public Optional<Advert> getAdvertById(Long advertId) {

        return advertRepository.findById(advertId).map(mapper::toAdvert);

    }
}
