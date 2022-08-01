package com.emlakjet.advert.usecase;

import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.publishing.exception.AdvertStatusException;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class DeleteAdvertUseCaseHandler implements VoidUseCaseHandler<Long> {

    private final AdvertPort advertPort;

    @Override
    public void handle(Long advertId) {

        var advert = advertPort.getAdvertById(advertId).orElseThrow(AdvertNotFoundException::new);

        if (advert.advertStatus() == null || advert.advertStatus().equals(AdvertStatus.PUBLISHED))
            throw new AdvertStatusException();

        advertPort.deleteAdvert(advertId);

    }
}
