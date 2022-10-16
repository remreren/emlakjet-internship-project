package com.emlakjet.adapter.listener;

import lombok.*;

import javax.persistence.Embeddable;

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