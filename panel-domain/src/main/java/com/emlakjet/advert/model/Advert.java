package com.emlakjet.advert.model;

import com.emlakjet.advert.enums.TradeType;

import java.math.BigDecimal;
import java.util.Date;

public record Advert(
        Long postId,
        String title,
        String description,
        BigDecimal price,
        LocationPoint location,
        TradeType tradeType,
        IndoorInfo indoorInfo,
        Date createdAt,
        Date updatedAt
) {
}
