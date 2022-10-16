package com.emlakjet.adapter.advert;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.emlakjet.advert.port.UnIndexerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdvertUnIndexerAdapter implements UnIndexerPort {

    private final ElasticsearchClient elasticsearchClient;

    @Override
    public void unIndex(Long advertId) {

        try {

            elasticsearchClient.delete(builder -> builder.index("listing_adverts_index")
                    .id(advertId.toString()));

        } catch (Exception e) {

            log.error("An error occurred unindexing advert:", e);

        }

    }
}
