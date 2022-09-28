package com.emlakjet.publishing.usecase;

import com.emlakjet.advert.exception.AdvertNotFoundException;
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
public class UnPublishAdvertUseCaseHandler implements UseCaseHandler<Advert, UnPublishAdvertUseCase> {

    private final AdvertPort advertPort;

    private final AdvertEventPort advertEventPort;

    @Override
    public Advert handle(UnPublishAdvertUseCase useCase) {

        var advert = advertPort.getAdvertById(useCase.advertId())
                               .map(oldAdvert -> oldAdvert.toBuilder()
                                                          .advertStatus(AdvertStatus.NOT_PUBLISHED)
                                                          .approvalStatus(ApprovalStatus.REJECTED) // TODO: Pending status eklenebilir
                                                          .build())
                               .orElseThrow(AdvertNotFoundException::new);

        var advertUpdated = advertPort.updateAdvert(advert);

        advertEventPort.advertUnPublished(advertUpdated.advertId());

        return advertUpdated;
    }
}
