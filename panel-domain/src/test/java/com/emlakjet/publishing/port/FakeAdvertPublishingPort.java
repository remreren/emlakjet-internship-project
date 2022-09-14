package com.emlakjet.publishing.port;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.publishing.usecase.UpdateAdvertStatusUseCase;

import java.math.BigInteger;
import java.util.Date;

public class FakeAdvertPublishingPort implements AdvertPublishingPort {
    @Override
    public Advert updateAdvertStatus(UpdateAdvertStatusUseCase updateAdvertStatusUseCase) {

        return new Advert(
                updateAdvertStatusUseCase.advertId(),
                "Title",
                "Description",
                BigInteger.valueOf(1000L),
                new LocationPoint(34D, 42D),
                TradeType.SALE,
                new IndoorInfo(90, 90, "2+1", 6, 2),
                ApprovalStatus.APPROVED,
                updateAdvertStatusUseCase.status(),
                new Date(),
                new Date());

    }
}
