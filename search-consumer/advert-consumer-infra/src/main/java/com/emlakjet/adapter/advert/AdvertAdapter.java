package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.listener.AdvertRepository;
import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertAdapter implements AdvertPort {

    private final AdvertRepository advertRepository;

    private final AdvertMapper advertMapper;

    @Override
    public Advert getAdvertByAdvertId(Long advertId) {

        var advert = advertRepository.findById(advertId).orElseThrow(AdvertNotFoundException::new);

        return advertMapper.toAdvert(advert);

    }
}
