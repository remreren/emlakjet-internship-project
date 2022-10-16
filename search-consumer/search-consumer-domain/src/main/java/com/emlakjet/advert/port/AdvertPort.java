package com.emlakjet.advert.port;

import com.emlakjet.advert.model.Advert;

public interface AdvertPort {

    Advert getAdvertByAdvertId(Long advertId);
}
