package com.emlakjet.publishing.usecase;

import com.emlakjet.advert.exception.AdvertApprovalStatusException;
import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.publishing.port.AdvertPublishingPort;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UpdateAdvertStatusUseCaseHandler implements UseCaseHandler<Advert, UpdateAdvertStatusUseCase> {

    private final AdvertPort advertPort;

    private final AdvertEventPort advertEventPort;

    private final AdvertPublishingPort advertPublishingPort;

    @Override
    public Advert handle(UpdateAdvertStatusUseCase useCase) {

        var advert = advertPort.getAdvertById(useCase.advertId()).orElseThrow(AdvertNotFoundException::new);

        if (advert.approvalStatus() == null
                || advert.approvalStatus().equals(ApprovalStatus.REJECTED)
                || advert.approvalStatus().equals(ApprovalStatus.REQUESTED))
            throw new AdvertApprovalStatusException(advert.approvalStatus());

        var updatedAdvert = advertPublishingPort.updateAdvertStatus(advert.toBuilder().advertStatus(useCase.status()).build());

        advertEventPort.advertStatusUpdated(useCase.advertId(), useCase.status(), updatedAdvert.approvalStatus());

        return updatedAdvert;

    }
}
