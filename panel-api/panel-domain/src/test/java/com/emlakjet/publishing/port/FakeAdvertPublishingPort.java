package com.emlakjet.publishing.port;

import com.emlakjet.advert.model.Advert;

public class FakeAdvertPublishingPort implements AdvertPublishingPort {
    @Override
    public Advert updateAdvertStatus(Advert advert) {

        return advert;

    }
}
