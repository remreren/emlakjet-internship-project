package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertAdapter implements AdvertPort {

    private final AdvertRepository advertRepository;

    private final AdvertMapper mapper;

    @Override
    public Advert createAdvert(Advert advert) {

        var createdAdvertEntity = advertRepository.save(mapper.toAdvertEntity(advert));

        return mapper.toAdvert(createdAdvertEntity);

    }

    @Override
    public Advert updateAdvert(Advert advert) {

        var updatedAdvertEntity = advertRepository.save(mapper.toAdvertEntity(advert));

        return mapper.toAdvert(updatedAdvertEntity);
    }

    @Override
    public void deleteAdvert(Long advertId) {

        advertRepository.deleteById(advertId);

    }

    @Override
    public Optional<Advert> getAdvertById(Long advertId) {

        return advertRepository.findById(advertId).map(mapper::toAdvert);

    }
}
