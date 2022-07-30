package com.emlakjet.advert.event;

import java.math.BigDecimal;

public record AdvertUpdatedMessage(
        Long advertId,
        String title,
        String description,
        BigDecimal price
) {
}
