package com.emlakjet.advert.usecase;

import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.publishing.exception.AdvertStatusException;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UpdateAdvertUseCaseHandler implements UseCaseHandler<Advert, UpdateAdvertUseCase> {

    private final AdvertPort advertPort;

    @Override
    public Advert handle(UpdateAdvertUseCase useCase) {

        var advert = advertPort.getAdvertById(useCase.advertId())
                .map(adv -> updateAdvert(adv, useCase))
                .orElseThrow(AdvertNotFoundException::new);

        if (advert.advertStatus() == null || advert.advertStatus().equals(AdvertStatus.PUBLISHED))
            throw new AdvertStatusException();

        return advertPort.updateAdvert(advert);

    }

    private Advert updateAdvert(Advert advert, UpdateAdvertUseCase updated) {
        return new Advert(advert.advertId(), updated.title(), updated.description(), updated.price(), updated.location(), updated.tradeType(), updated.indoorInfo(), advert.approvalStatus(), advert.advertStatus(), null, null);
    }
}
