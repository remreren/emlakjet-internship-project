package com.emlakjet.post.usecase;

import com.emlakjet.commons.model.UseCase;
import com.emlakjet.post.enums.TradeType;
import com.emlakjet.post.model.IndoorInfo;
import com.emlakjet.post.model.LocationPoint;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreatePostUseCase(
        Long ownerId,
        String title,
        String description,
        BigDecimal price,
        LocationPoint location,
        TradeType tradeType,
        IndoorInfo indoorInfo
) implements UseCase {

}
