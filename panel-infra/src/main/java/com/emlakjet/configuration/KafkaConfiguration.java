package com.emlakjet.configuration;

import lombok.Setter;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.List;
import java.util.Map;

@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaConfiguration {

    private List<String> bootstrapServers;

    private KafkaProducerConfiguration producer;

    @Bean
    public ProducerFactory<String, Object> advertEventProducerFactory() {
        Map<String, Object> producerConfig = Map.of(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, producer.keySerializer(),
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, producer.valueSerializer(),
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new DefaultKafkaProducerFactory<>(producerConfig);
    }

    @Bean
    public KafkaTemplate<String, Object> advertEventKafkaTemplate() {
        return new KafkaTemplate<>(advertEventProducerFactory());
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic advertEventsTopic() {
        return new NewTopic("advert-events", 1, (short) 1);
    }

    public record KafkaProducerConfiguration(
            Class<Serializer<?>> keySerializer,
            Class<Serializer<?>> valueSerializer
    ) {

    }
}
