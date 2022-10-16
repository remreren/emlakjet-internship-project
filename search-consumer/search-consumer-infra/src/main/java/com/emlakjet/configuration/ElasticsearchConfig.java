package com.emlakjet.configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticsearchConfig {

    private String schema;

    private String host;

    private Integer port;

    @Bean
    public RestClient esRestClient() {
        var clientBuilder = RestClient.builder(new HttpHost(host, port, schema));
        return clientBuilder.build();
    }

    @Bean
    public ElasticsearchTransport esTransport(RestClient esRestClient) {
        return new RestClientTransport(
                esRestClient, new JacksonJsonpMapper());
    }

    @Bean
    public ElasticsearchClient elasticsearchClient(ElasticsearchTransport esTransport) {
        return new ElasticsearchClient(esTransport);
    }
}
