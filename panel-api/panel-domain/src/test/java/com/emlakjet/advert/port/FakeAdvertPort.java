package com.emlakjet.advert.port;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

public class FakeAdvertPort implements AdvertPort {

    @Override
    public Advert createAdvert(Advert advert) {
        return advert.toBuilder().advertId(1L).createdAt(new Date()).updatedAt(new Date()).build();
    }

    @Override
    public Advert updateAdvert(Advert advert) {
        return advert;
    }

    @Override
    public void deleteAdvert(Long advertId) {
        // deleted
    }

    @Override
    public Optional<Advert> getAdvertById(Long advertId) {
        var advert = new Advert(
                advertId,
                "Title",
                "Description",
                BigInteger.valueOf(1000L),
                new LocationPoint(34D, 42D),
                TradeType.SALE,
                new IndoorInfo(90, 90, "2+1", 5, 3),
                ApprovalStatus.APPROVED,
                AdvertStatus.NOT_PUBLISHED,
                new Date(),
                new Date());
        return Optional.of(advert);
    }
}