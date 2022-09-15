package com.emlakjet.adapter.publishing;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.publishing.port.AdvertPublishingPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertPublishingAdapter implements AdvertPublishingPort {

    private final AdvertRepository advertRepository;

    private final AdvertMapper mapper;

    @Override
    public Advert updateAdvertStatus(Advert advert) {

        var updatedEntity = mapper.toAdvertEntity(advert);

        advertRepository.save(updatedEntity);

        return advert;

    }
}
