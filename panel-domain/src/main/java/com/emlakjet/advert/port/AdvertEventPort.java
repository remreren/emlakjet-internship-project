package com.emlakjet.advert.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.publishing.enums.AdvertStatus;

public interface AdvertEventPort {

    void advertCreated(Advert advert);

    void advertUpdated(Advert advert);

    void advertDeleted(Long advertId);

    void advertStatusUpdated(Long advertId, AdvertStatus status);
}
