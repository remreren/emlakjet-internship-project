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
    public Advert updateApprovalStatus(AdvertApprovalUseCase useCase) {
        var advert = new Advert(
                useCase.advertId(),
                "Title",
                "Description",
                BigInteger.valueOf(1000L),
                new LocationPoint(34D, 42D),
                TradeType.SALE,
                new IndoorInfo(90, 90, "2+1", 6, 2),
                useCase.approvalStatus(),
                AdvertStatus.PUBLISHED,
                new Date(),
                new Date());
        return advert;
    }
}
