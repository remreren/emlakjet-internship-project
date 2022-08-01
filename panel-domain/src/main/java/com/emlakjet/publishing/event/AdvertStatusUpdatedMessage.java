package com.emlakjet.publishing.event;

import com.emlakjet.publishing.enums.AdvertStatus;

public record AdvertStatusUpdatedMessage(
        Long advertId,
        AdvertStatus status
) {
}
