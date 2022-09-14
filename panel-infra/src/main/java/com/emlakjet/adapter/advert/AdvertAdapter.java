package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.event.AdvertEvent;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.usecase.CreateAdvertUseCase;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertAdapter implements AdvertPort {

    private final KafkaTemplate<String, AdvertEvent> advertEventSender;

    private static final String ADVERT_EVENTS = "advert-events";

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

        var advertEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertCreated(mapper.toAdvertCreatedMessage(createdAdvert))
                                     .build();

        advertEventSender.send(ADVERT_EVENTS, advertEvent);

        return mapper.toAdvert(createdAdvert);
    }

    @Override
    public Advert updateAdvert(Advert advert) {

        var advertEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertUpdated(mapper.toAdvertUpdatedMessage(advert))
                                     .build();

        advertEventSender.send(ADVERT_EVENTS, advertEvent);

        return advert;
    }

    @Override
    public void deleteAdvert(Long advertId) {

        advertRepository.deleteById(advertId);

        var advertEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertDeleted(mapper.toAdvertDeletedMessage(advertId))
                                     .build();

        advertEventSender.send(ADVERT_EVENTS, advertEvent);

    }

    @Override
    public Optional<Advert> getAdvertById(Long advertId) {

        return advertRepository.findById(advertId).map(mapper::toAdvert);

    }
}
