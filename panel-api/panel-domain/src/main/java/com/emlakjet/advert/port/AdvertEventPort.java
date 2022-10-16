package com.emlakjet.advert.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;

public interface AdvertEventPort {

    void advertCreated(Advert advert);

    void advertUpdated(Advert advert);

    void advertDeleted(Long advertId);

    void advertStatusUpdated(Long advertId, AdvertStatus advertStatus, ApprovalStatus approvalStatus);

    void advertApproved(Long advertId);

    void advertUnPublished(Long advertId);
}
