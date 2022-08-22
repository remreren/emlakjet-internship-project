package com.emlakjet.publishing.event;

import com.emlakjet.advert.event.AdvertEventsAggregate;
import com.emlakjet.publishing.enums.AdvertStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class AdvertStatusUpdatedMessage extends AdvertEventsAggregate {
    private final Long advertId;
    private final AdvertStatus status;
}
