package com.emlakjet.adapter.listener;

import com.emlakjet.advert.event.*;
import com.emlakjet.advert.usecase.IndexAdvertUseCase;
import com.emlakjet.advert.usecase.UnIndexAdvertUseCase;
import com.emlakjet.commons.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.apache.kafka.streams.state.Stores;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdvertEventListener {

    private final SerdeFactory serdeFactory;

    private final VoidUseCaseHandler<IndexAdvertUseCase> indexAdvertUseCaseHandler;

    private final VoidUseCaseHandler<UnIndexAdvertUseCase> unIndexAdvertUseCaseHandler;

    @Bean
    public KTable<String, AdvertEventAggregate> advertStream(StreamsBuilder sb) {
        return sb.stream("advert-events", Consumed.with(Serdes.String(), serdeFactory.of(AdvertEvent.class)))
                .peek(this::processEvent)
                .groupByKey()
                .aggregate(() -> AdvertEventAggregate.newBuilder().build(),
                        (id, event, aggregate) -> AdvertEventAggregate.newBuilder(aggregate).build(),
                        Named.as("aggregate-advert-events"),
                        Materialized.<String, AdvertEventAggregate>as(
                                Stores.persistentKeyValueStore("advert-aggregate-store"))
                                .withKeySerde(Serdes.String())
                                .withValueSerde(serdeFactory.of(AdvertEventAggregate.class)));
    }

    private void processEvent(String id, AdvertEvent event) {
        if (event.getPayloadCase().equals(AdvertEvent.PayloadCase.ADVERT_APPROVED)) {
            indexAdvertUseCaseHandler.handle(new IndexAdvertUseCase(event.getAdvertApproved().getAdvertId()));
        } else if (event.getPayloadCase().equals(AdvertEvent.PayloadCase.ADVERT_UNPUBLISHED)) {
            unIndexAdvertUseCaseHandler.handle(new UnIndexAdvertUseCase(event.getAdvertUnpublished().getAdvertId()));
        }
    }
}
