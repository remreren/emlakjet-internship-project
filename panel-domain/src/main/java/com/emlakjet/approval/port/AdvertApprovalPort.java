package com.emlakjet.approval.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.approval.usecase.AdvertApprovalUseCase;

public interface AdvertApprovalPort {

    Advert updateApprovalStatus(AdvertApprovalUseCase useCase);
}
