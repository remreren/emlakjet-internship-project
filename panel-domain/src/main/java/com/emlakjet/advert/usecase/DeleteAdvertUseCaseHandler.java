package com.emlakjet.advert.usecase;

import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class DeleteAdvertUseCaseHandler implements VoidUseCaseHandler<Long> {

    private final AdvertPort advertPort;

    @Override
    public void handle(Long useCase) {

        advertPort.deletePost(useCase);

    }
}
