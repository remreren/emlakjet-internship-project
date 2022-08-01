package com.emlakjet.advert.usecase;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class CreateAdvertUseCaseHandler implements UseCaseHandler<Advert, CreateAdvertUseCase> {

    private final AdvertPort advertPort;

    @Override
    public Advert handle(CreateAdvertUseCase useCase) {

        return advertPort.createAdvert(useCase);

    }
}
