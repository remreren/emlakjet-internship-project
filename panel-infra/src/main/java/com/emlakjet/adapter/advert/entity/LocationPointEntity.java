package com.emlakjet.adapter.advert.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.util.Objects;

// @Table(name = "location") // TODO: this could be removed if checked and assured that this is working.
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