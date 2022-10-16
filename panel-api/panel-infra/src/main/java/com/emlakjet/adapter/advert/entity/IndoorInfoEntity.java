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
public final class IndoorInfoEntity {
    private Integer squareMeter;
    private Integer netSquareMeter;
    private String roomCount;
    private Integer floorCount;
    private Integer floorNumber;

}
