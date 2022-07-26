package com.emlakjet.advert.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;

public class FakeAdvertEventPort implements AdvertEventPort {

    @Override
    public void advertCreated(Advert advert) {
        // created
    }

    @Override
    public void advertUpdated(Advert advert) {
        // updated
    }

    @Override
    public void advertDeleted(Long advertId) {
        // deleted
    }

    @Override
    public void advertStatusUpdated(Long advertId, AdvertStatus advertStatus, ApprovalStatus approvalStatus) {
        // status updated
    }

    @Override
    public void advertApproved(Long advertId) {

    }

    @Override
    public void advertUnPublished(Long advertId) {

    }
}
