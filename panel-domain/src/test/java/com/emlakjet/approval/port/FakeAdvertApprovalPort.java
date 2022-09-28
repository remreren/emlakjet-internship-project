package com.emlakjet.approval.port;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.approval.usecase.AdvertApprovalUseCase;
import com.emlakjet.publishing.enums.AdvertStatus;

import java.math.BigInteger;
import java.util.Date;

public class FakeAdvertApprovalPort implements AdvertApprovalPort {

    @Override
    public Advert updateApprovalStatus(Advert advert) {
        return advert;
    }
}
