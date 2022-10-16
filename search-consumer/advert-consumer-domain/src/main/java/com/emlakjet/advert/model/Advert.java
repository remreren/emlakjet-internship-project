package com.emlakjet.advert.model;

import java.math.BigInteger;
import java.util.Date;

public record Advert(
        Long advertId,
        Long ownerId,
        String title,
        String description,
        BigInteger price,
        LocationPoint location,
        IndoorInfo indoorInfo,
        Date createdAt,
        Date updatedAt
) {
}
