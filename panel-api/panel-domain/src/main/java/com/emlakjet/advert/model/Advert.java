package com.emlakjet.advert.model;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.Builder;

import java.math.BigInteger;
import java.util.Date;

@Builder(toBuilder = true)
public record Advert(
        Long advertId,
        String title,
        String description,
        BigInteger price,
        LocationPoint location,
        TradeType tradeType,
        IndoorInfo indoorInfo,
        ApprovalStatus approvalStatus,
        AdvertStatus advertStatus,
        Date createdAt,
        Date updatedAt
) {
}
