package com.emlakjet.approval.port;

import com.emlakjet.advert.model.Advert;

public interface AdvertApprovalPort {

    Advert updateApprovalStatus(Advert advert);
}
