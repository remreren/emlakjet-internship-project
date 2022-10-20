package com.emlakjet.adapter.advert;

import com.emlakjet.advert.event.AdvertApprovedEvent;
import com.emlakjet.advert.event.AdvertEvent;
import com.emlakjet.advert.event.AdvertStatusUpdatedEvent;
import com.emlakjet.advert.event.AdvertUnPublishedEvent;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
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

        send(ADVERT_EVENTS, advertCreatedEvent);

    }

    @Override
    public void advertUpdated(Advert advert) {

        var advertUpdatedEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertUpdated(mapper.toAdvertUpdatedMessage(advert))
                                     .build();

        send(ADVERT_EVENTS, advertUpdatedEvent);

    }

    @Override
    public void advertDeleted(Long advertId) {

        var advertDeletedEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertDeleted(mapper.toAdvertDeletedMessage(advertId))
                                     .build();

        send(ADVERT_EVENTS, advertDeletedEvent);

    }

    @Override
    public void advertStatusUpdated(Long advertId, AdvertStatus advertStatus, ApprovalStatus approvalStatus) {

        var advertStatusUpdatedEvent = AdvertEvent.newBuilder()
                                     .setEventId(UUID.randomUUID().toString())
                                     .setAdvertStatusUpdated(AdvertStatusUpdatedEvent.newBuilder()
                                                                                     .setAdvertId(advertId)
                                                                                     .setAdvertStatus(advertStatus.getSlug())
                                                                                     .setApprovalStatus(approvalStatus.getSlug())
                                                                                     .build())
                                     .build();

        send(ADVERT_EVENTS, advertStatusUpdatedEvent);

    }

    @Override
    public void advertApproved(Long advertId) {

        var advertApprovedEvent = AdvertEvent.newBuilder()
                                             .setEventId(UUID.randomUUID().toString())
                                             .setAdvertApproved(AdvertApprovedEvent.newBuilder()
                                                                                   .setAdvertId(advertId)
                                                                                   .build())
                                             .build();

        send(ADVERT_EVENTS, advertApprovedEvent);

    }

    @Override
    public void advertUnPublished(Long advertId) {

        var advertUnPublishedEvent = AdvertEvent.newBuilder()
                                             .setEventId(UUID.randomUUID().toString())
                                             .setAdvertUnpublished(AdvertUnPublishedEvent.newBuilder()
                                                                                      .setAdvertId(advertId)
                                                                                      .build())
                                             .build();

        send(ADVERT_EVENTS, advertUnPublishedEvent);

    }

    private void send(String topic, AdvertEvent created) {
        advertEventSender.send(new ProducerRecord<>(topic, created));
    }
}
