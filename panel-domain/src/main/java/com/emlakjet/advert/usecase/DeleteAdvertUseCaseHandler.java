package com.emlakjet.advert.usecase;

import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.VoidUseCaseHandler;
import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.publishing.exception.AdvertStatusException;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class DeleteAdvertUseCaseHandler implements VoidUseCaseHandler<DeleteAdvertUseCase> {

    private final AdvertPort advertPort;

    private final AdvertEventPort advertEventPort;

    @Override
    public void handle(DeleteAdvertUseCase deleteAdvertUseCase) {

        var advert = advertPort.getAdvertById(deleteAdvertUseCase.advertId()).orElseThrow(AdvertNotFoundException::new);

        if (advert.advertStatus() == null || advert.advertStatus().equals(AdvertStatus.PUBLISHED))
            throw new AdvertStatusException();

        advertPort.deleteAdvert(deleteAdvertUseCase.advertId());

        advertEventPort.advertDeleted(deleteAdvertUseCase.advertId());

    }
}
