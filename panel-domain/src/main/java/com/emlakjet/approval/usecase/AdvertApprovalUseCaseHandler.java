package com.emlakjet.approval.usecase;

import com.emlakjet.advert.exception.AdvertNotFoundException;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.approval.port.AdvertApprovalPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class AdvertApprovalUseCaseHandler implements UseCaseHandler<Advert, AdvertApprovalUseCase> {

    private final AdvertPort advertPort;

    private final AdvertApprovalPort advertApprovalPort;

    private final AdvertEventPort advertEventPort;

    @Override
    public Advert handle(AdvertApprovalUseCase useCase) {

        var advertFound = advertPort.getAdvertById(useCase.advertId())
                                    .map(advert -> advert.toBuilder()
                                                         .approvalStatus(useCase.approvalStatus())
                                                         .advertStatus(AdvertStatus.PUBLISHED) // TODO: approve alıyorsa published olması gerek reject yiyorsa not published olması gerekli
                                                         .build())
                                    .orElseThrow(AdvertNotFoundException::new); // TODO: adaptera taşıyabiliriz, böylece optional değil non optional yapılabilir.

        var advertSaved = advertApprovalPort.updateApprovalStatus(advertFound);

        advertEventPort.advertApproved(advertFound.advertId());

        return advertSaved;

    }
}
