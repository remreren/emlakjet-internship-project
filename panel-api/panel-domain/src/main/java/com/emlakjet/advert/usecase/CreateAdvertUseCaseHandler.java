package com.emlakjet.advert.usecase;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class CreateAdvertUseCaseHandler implements UseCaseHandler<Advert, CreateAdvertUseCase> {

    private final AdvertPort advertPort;

    private final AdvertEventPort advertEventPort;

    @Override
    public Advert handle(CreateAdvertUseCase useCase) {

        var advert = new Advert(null,
                                useCase.title(),
                                useCase.description(),
                                useCase.price(),
                                useCase.location(),
                                useCase.tradeType(),
                                useCase.indoorInfo(),
                                ApprovalStatus.REQUESTED,
                                AdvertStatus.HANG,
                                null,
                                null);

        var createdAdvert = advertPort.createAdvert(advert);

        advertEventPort.advertCreated(createdAdvert);

        return createdAdvert;

    }
}
