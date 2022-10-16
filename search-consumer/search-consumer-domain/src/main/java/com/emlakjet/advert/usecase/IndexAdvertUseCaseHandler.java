package com.emlakjet.advert.usecase;

import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.port.IndexerPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class IndexAdvertUseCaseHandler implements VoidUseCaseHandler<IndexAdvertUseCase> {

    private final AdvertPort advertPort;

    private final IndexerPort indexerPort;

    @Override
    public void handle(IndexAdvertUseCase useCase) {

        var advert = advertPort.getAdvertByAdvertId(useCase.advertId());

        indexerPort.index(advert);

    }
}
