package com.emlakjet.advert.event;

import java.math.BigDecimal;

public record AdvertCreatedMessage(
        Long advertId,
        String title,
        String description,
        BigDecimal price
) {
}
