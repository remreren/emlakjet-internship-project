package com.emlakjet.adapter.advert.rest.dto;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record AdvertRequest(
        @NotNull Long ownerId,
        @NotNull @NotBlank String title,
        @NotNull @NotBlank String description,
        @NotNull BigDecimal price,
        LocationPoint location,
        @NotNull TradeType tradeType,
        IndoorInfo indoorInfo
) {
}
