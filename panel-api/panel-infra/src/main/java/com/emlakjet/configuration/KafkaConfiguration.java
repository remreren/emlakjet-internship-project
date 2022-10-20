package com.emlakjet.configuration;

import com.emlakjet.advert.event.AdvertEvent;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Setter
@Configuration
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaConfiguration {

    private final KafkaProperties properties;

    @Bean
    public ProducerFactory<String, AdvertEvent> advertEventProducerFactory() {
        return new DefaultKafkaProducerFactory<>(properties.buildProducerProperties());
    }

    @Bean
    public KafkaTemplate<String, AdvertEvent> advertEventKafkaTemplate() {
        return new KafkaTemplate<>(advertEventProducerFactory());
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        return new KafkaAdmin(properties.buildAdminProperties());
    }
}
