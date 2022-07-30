package com.emlakjet.advert.usecase;

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

        return advertPort.updatePost(useCase);

    }
}
