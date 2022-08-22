package com.emlakjet.adapter.advert.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;
import java.util.Objects;

// @Table(name = "indoorInfo") // TODO: this could be removed if checked and assured that this is working.
@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public final class IndoorInfoEntity {
    private Integer squareMeter;
    private Integer netSquareMeter;
    private String roomCount;
    private Integer floorCount;
    private Integer floorNumber;

}
