package com.emlakjet.advert.event;

import com.emlakjet.advert.enums.AdvertStatus;

public record AdvertStatusUpdatedMessage(
        Long advertId,
        AdvertStatus status
) {
}
