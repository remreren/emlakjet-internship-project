package com.emlakjet.adapter.post.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Table(name = "indoorInfo") // TODO: this could be removed if checked and assured that this is working.
@Embeddable
public record IndoorInfoEntity(
        Integer squareMeter,
        Integer netSquareMeter,
        String roomCount,
        Integer floorCount,
        Integer floorNumber
) {
    public IndoorInfoEntity() {
        this(null, null, null, null, null);
    }
}
