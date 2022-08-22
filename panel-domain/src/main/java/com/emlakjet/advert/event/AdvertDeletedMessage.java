package com.emlakjet.advert.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AdvertDeletedMessage extends AdvertEventsAggregate {
    private final Long advertId;
}
