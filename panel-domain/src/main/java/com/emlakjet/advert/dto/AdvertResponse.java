package com.emlakjet.advert.dto;

import com.emlakjet.advert.enums.AdvertStatus;
import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.approval.enums.ApprovalStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record AdvertResponse(
        Long advertId,
        String title,
        String description,
        BigDecimal price,
        LocationPoint location,
        TradeType tradeType,
        IndoorInfo indoorInfo,
        ApprovalStatus approvalStatus,
        AdvertStatus advertStatus,
        Date createdAt,
        Date updatedAt
) {
}
