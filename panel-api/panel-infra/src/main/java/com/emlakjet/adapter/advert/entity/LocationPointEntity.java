package com.emlakjet.adapter.advert.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public final class LocationPointEntity {
    private Double lat;
    private Double lon;
}