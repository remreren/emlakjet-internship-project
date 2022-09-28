package com.emlakjet.advert.usecase;

import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.publishing.exception.AdvertStatusException;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UpdateAdvertUseCaseHandler implements UseCaseHandler<Advert, UpdateAdvertUseCase> {

    private final AdvertPort advertPort;

    private final AdvertEventPort advertEventPort;

    @Override
    public Advert handle(UpdateAdvertUseCase useCase) {

        var advert = advertPort.getAdvertById(useCase.advertId())
                .map(adv -> updateAdvert(adv, useCase))
                .orElseThrow(AdvertNotFoundException::new);

        if (advert.advertStatus() == null || advert.advertStatus().equals(AdvertStatus.PUBLISHED))
            throw new AdvertStatusException();

        var updatedAdvert = advertPort.updateAdvert(advert);

        advertEventPort.advertUpdated(updatedAdvert);

        return updatedAdvert;

    }

    private Advert updateAdvert(Advert advert, UpdateAdvertUseCase updated) {
        return advert.toBuilder()
                     .title(updated.title())
                     .description(updated.description())
                     .price(updated.price())
                     .location(updated.location())
                     .tradeType(updated.tradeType())
                     .indoorInfo(updated.indoorInfo())
                     .approvalStatus(ApprovalStatus.REQUESTED)
                     .advertStatus(AdvertStatus.NOT_PUBLISHED)
                     .build();
    }
}
