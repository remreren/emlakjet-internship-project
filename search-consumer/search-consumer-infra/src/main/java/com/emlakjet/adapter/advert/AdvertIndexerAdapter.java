package com.emlakjet.adapter.advert;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.IndexerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdvertIndexerAdapter implements IndexerPort {

    private final ElasticsearchClient elasticsearchClient;

    @Override
    public void index(Advert advert) {


        try {

            elasticsearchClient.index(builder -> builder.index("listing_adverts_index")
                    .id(advert.advertId().toString())
                    .document(advert));

        } catch (IOException e) {

            log.error("Elastic failed to index: ", e);

        }

    }
}
