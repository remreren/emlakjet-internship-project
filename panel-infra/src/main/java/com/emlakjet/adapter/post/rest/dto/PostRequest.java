package com.emlakjet.adapter.post.rest.dto;

import com.emlakjet.post.enums.TradeType;
import com.emlakjet.post.model.IndoorInfo;
import com.emlakjet.post.model.LocationPoint;
import com.emlakjet.post.usecase.CreatePostUseCase;
import com.emlakjet.post.usecase.UpdatePostUseCase;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record PostRequest(
        @NotNull Long ownerId,
        @NotNull @NotBlank String title,
        @NotNull @NotBlank String description,
        @NotNull BigDecimal price,
        LocationPoint location,
        @NotNull TradeType tradeType,
        IndoorInfo indoorInfo
) {

    public CreatePostUseCase toUseCase() {
        return CreatePostUseCase.builder()
                .ownerId(ownerId)
                .title(title)
                .description(description)
                .price(price)
                .location(location)
                .tradeType(tradeType)
                .indoorInfo(indoorInfo)
                .build();
    }

    public UpdatePostUseCase toUseCase(Long postId) {
        return UpdatePostUseCase.builder()
                .postId(postId)
                .ownerId(ownerId)
                .title(title)
                .description(description)
                .price(price)
                .location(location)
                .tradeType(tradeType)
                .indoorInfo(indoorInfo)
                .build();
    }
}
