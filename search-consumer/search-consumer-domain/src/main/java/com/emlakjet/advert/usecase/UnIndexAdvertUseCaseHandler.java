package com.emlakjet.advert.usecase;

import com.emlakjet.advert.port.UnIndexerPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UnIndexAdvertUseCaseHandler implements VoidUseCaseHandler<UnIndexAdvertUseCase> {

    private final UnIndexerPort unIndexerPort;

    @Override
    public void handle(UnIndexAdvertUseCase useCase) {

        unIndexerPort.unIndex(useCase.advertId());

    }
}
