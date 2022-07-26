package com.emlakjet.post.model;

import com.emlakjet.post.enums.TradeType;

import java.math.BigDecimal;
import java.util.Date;

public record Post(
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
