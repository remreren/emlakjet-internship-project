package com.emlakjet.adapter.approval;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.event.AdvertApprovedEvent;
import com.emlakjet.advert.event.AdvertEvent;
import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.approval.port.AdvertApprovalPort;
import com.emlakjet.approval.usecase.AdvertApprovalUseCase;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertApprovalAdapter implements AdvertApprovalPort {

    private final KafkaTemplate<String, AdvertEvent> advertEventSender;

    private final AdvertRepository advertRepository;

    private final AdvertMapper mapper;

    @Override
    public Advert updateApprovalStatus(AdvertApprovalUseCase useCase) {

        var advertFound = advertRepository.findById(useCase.advertId())
                .map(advert -> advert.toBuilder()
                        .approvalStatus(useCase.approvalStatus())
                        .advertStatus(AdvertStatus.PUBLISHED)
                        .build())
                .orElseThrow(AdvertNotFoundException::new);

        advertEventSender.send("advert-events", AdvertEvent.newBuilder()
                                                           .setAdvertApproved(AdvertApprovedEvent.newBuilder()
                                                                                                 .setAdvertId(useCase.advertId())
                                                                                                 .build())
                                                           .build());

        return mapper.toAdvert(advertRepository.save(advertFound));

    }
}
