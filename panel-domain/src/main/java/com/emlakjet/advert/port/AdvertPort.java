package com.emlakjet.advert.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.usecase.CreateAdvertUseCase;
import com.emlakjet.advert.usecase.UpdateAdvertUseCase;

import java.util.Optional;

public interface AdvertPort {

    Advert createAdvert(CreateAdvertUseCase advert);

    Advert updateAdvert(Advert advert);

    void deleteAdvert(Long advertId);

    Optional<Advert> getAdvertById(Long advertId);
}
