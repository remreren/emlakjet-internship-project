package com.emlakjet.listing.port;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.listing.usecase.AdvertListingUseCase;
import com.emlakjet.publishing.enums.AdvertStatus;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class FakeAdvertListingPort implements AdvertListingPort {

    @Override
    public List<Advert> getPostsPaging(AdvertListingUseCase advertListingUseCase) {
        var advert = new Advert(
                1L,
                "Title",
                "Description",
                BigInteger.valueOf(1000L),
                new LocationPoint(34D, 42D),
                TradeType.SALE,
                new IndoorInfo(90, 90, "2+1", 6, 2),
                ApprovalStatus.APPROVED,
                AdvertStatus.PUBLISHED,
                new Date(),
                new Date());
        return List.of(advert);
    }
}
