package com.emlakjet.adapter.post.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "location") // TODO: this could be removed if checked and assured that this is working.
public record LocationPointEntity(
        Double lat,
        Double lng
) {
    public LocationPointEntity() {
        this(null, null);
    }
}