package com.emlakjet.adapter.listener;

import com.google.protobuf.Message;
import io.confluent.kafka.streams.serdes.protobuf.KafkaProtobufSerde;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DefaultSerdeFactory implements SerdeFactory {

    private final KafkaProperties kafkaProperties;

    @Override
    public <T extends Message> KafkaProtobufSerde<T> of(Class<T> clazz) {
        var serde = new KafkaProtobufSerde<>(clazz);
        serde.configure(kafkaProperties.getProperties(), false);
        return serde;
    }
}
