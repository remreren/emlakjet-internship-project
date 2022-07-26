package com.emlakjet.post.dto;

import com.emlakjet.post.enums.TradeType;
import com.emlakjet.post.model.IndoorInfo;
import com.emlakjet.post.model.LocationPoint;
import com.emlakjet.post.model.Post;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;

@Builder
public record PostResponse(
        String title,
        String description,
        BigDecimal price,
        LocationPoint location,
        TradeType tradeType,
        IndoorInfo indoorInfo,
        Date updatedAt
) {

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .title(post.title())
                .description(post.description())
                .price(post.price())
                .location(post.location())
                .tradeType(post.tradeType())
                .indoorInfo(post.indoorInfo())
                .updatedAt(post.updatedAt())
                .build();
    }
}
