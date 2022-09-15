package com.emlakjet.advert.port;

import com.emlakjet.advert.model.Advert;

import java.util.Optional;

public interface AdvertPort {

    Advert createAdvert(Advert advert);

    Advert updateAdvert(Advert advert);

    void deleteAdvert(Long advertId);

    Optional<Advert> getAdvertById(Long advertId);
}
