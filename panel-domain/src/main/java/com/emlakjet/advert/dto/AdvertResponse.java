package com.emlakjet.advert.dto;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record AdvertResponse(
        String title,
        String description,
        BigDecimal price,
        LocationPoint location,
        TradeType tradeType,
        IndoorInfo indoorInfo,
        Date updatedAt
) {
}
