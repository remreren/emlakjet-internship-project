package com.emlakjet.advert.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class AdvertCreatedMessage extends AdvertEventsAggregate {
    private final Long advertId;
    private final String title;
    private final String description;
    private final BigDecimal price;
}
