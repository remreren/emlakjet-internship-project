package com.emlakjet.adapter.publishing;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.event.AdvertEvent;
import com.emlakjet.advert.event.AdvertStatusUpdatedEvent;
import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.publishing.port.AdvertPublishingPort;
import com.emlakjet.publishing.usecase.UpdateAdvertStatusUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertPublishingAdapter implements AdvertPublishingPort {

    private final KafkaTemplate<String, AdvertEvent> advertEventSender;

    private static final String ADVERT_STATUS_UPDATED = "advert-events";

    private final AdvertRepository advertRepository;

    private final AdvertMapper mapper;

    @Override
    public Advert updateAdvertStatus(UpdateAdvertStatusUseCase advert) {

        var advertFound = advertRepository.findById(advert.advertId())
                .map(adv -> adv.toBuilder().advertStatus(advert.status()).build())
                .orElseThrow(AdvertNotFoundException::new);

        var advertUpdated  = mapper.toAdvert(advertRepository.save(advertFound));

        var advertEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertStatusUpdated(AdvertStatusUpdatedEvent.newBuilder()
                                                                                     .setAdvertId(advertUpdated.advertId())
                                                                                     .setAdvertStatus(advertUpdated.advertStatus().getSlug())
                                                                                     .build())
                                     .build();


        advertEventSender.send(ADVERT_STATUS_UPDATED, advertEvent);

        return advertUpdated;

    }
}
