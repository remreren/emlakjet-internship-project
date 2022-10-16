package com.emlakjet.adapter.listener;

import com.google.protobuf.Message;
import io.confluent.kafka.streams.serdes.protobuf.KafkaProtobufSerde;

public interface SerdeFactory {
    <T extends Message>KafkaProtobufSerde<T> of(Class<T> clazz);
}
