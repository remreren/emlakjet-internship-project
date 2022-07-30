package com.emlakjet.approval.usecase;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.approval.port.AdvertApprovalPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class AdvertApprovalUseCaseHandler implements UseCaseHandler<Advert, AdvertApprovalUseCase> {

    private final AdvertApprovalPort advertApprovalPort;

    @Override
    public Advert handle(AdvertApprovalUseCase useCase) {

        return advertApprovalPort.updateApprovalStatus(useCase);

    }
}
