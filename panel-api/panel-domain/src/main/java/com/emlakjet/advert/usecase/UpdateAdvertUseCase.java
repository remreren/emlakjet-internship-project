package com.emlakjet.advert.usecase;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.commons.model.UseCase;
import lombok.Builder;

import java.math.BigInteger;

@Builder(toBuilder = true)
public record UpdateAdvertUseCase(
        Long advertId,
        Long ownerId,
        String title,
        String description,
        BigInteger price,
        LocationPoint location,
        TradeType tradeType,
        IndoorInfo indoorInfo
) implements UseCase {
}