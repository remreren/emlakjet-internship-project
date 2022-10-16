package com.emlakjet.advert.model;

public record IndoorInfo(
        Integer squareMeter,
        Integer netSquareMeter,
        String roomCount,
        Integer floorCount,
        Integer floorNumber
) {
}
