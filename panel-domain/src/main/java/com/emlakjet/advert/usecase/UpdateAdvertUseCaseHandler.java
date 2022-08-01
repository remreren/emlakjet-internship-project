package com.emlakjet.advert.usecase;

import com.emlakjet.advert.enums.AdvertStatus;
import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.exception.AdvertStatusException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UpdateAdvertUseCaseHandler implements UseCaseHandler<Advert, UpdateAdvertUseCase> {

    private final AdvertPort advertPort;

    @Override
    public Advert handle(UpdateAdvertUseCase useCase) {

        var advert = advertPort.getAdvertById(useCase.advertId()).orElseThrow(AdvertNotFoundException::new);

        if (advert.advertStatus() == null || advert.advertStatus().equals(AdvertStatus.PUBLISHED))
            throw new AdvertStatusException();

        return advertPort.updateAdvert(useCase);

    }
}
