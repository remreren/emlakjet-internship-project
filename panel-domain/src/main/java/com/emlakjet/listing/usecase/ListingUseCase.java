package com.emlakjet.listing.usecase;

import lombok.Builder;

@Builder(toBuilder = true)
public record ListingUseCase(Integer page, Integer pageSize) {
}
