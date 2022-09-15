package com.emlakjet.adapter.advert;

import com.emlakjet.advert.event.AdvertEvent;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

@RequiredArgsConstructor
public class AdvertEventAdapter implements AdvertEventPort {

    private final AdvertMapper mapper;

    private final KafkaTemplate<String, AdvertEvent> advertEventSender;

    private static final String ADVERT_EVENTS = "advert-events";

    @Override
    public void advertCreated(Advert advert) {

        var advertCreatedEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertCreated(mapper.toAdvertCreatedMessage(advert))
                                     .build();

        advertEventSender.send(ADVERT_EVENTS, advertCreatedEvent);

    }

    @Override
    public void advertUpdated(Advert advert) {

        var advertUpdatedEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertUpdated(mapper.toAdvertUpdatedMessage(advert))
                                     .build();

        advertEventSender.send(ADVERT_EVENTS, advertUpdatedEvent);

    }

    @Override
    public void advertDeleted(Long advertId) {

        var advertDeletedEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertDeleted(mapper.toAdvertDeletedMessage(advertId))
                                     .build();

        advertEventSender.send(ADVERT_EVENTS, advertDeletedEvent);

    }

    @Override
    public void advertStatusUpdated(Long advertId, AdvertStatus status) {

    }
}
