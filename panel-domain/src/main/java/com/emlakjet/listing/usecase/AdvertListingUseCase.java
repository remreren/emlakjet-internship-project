package com.emlakjet.listing.usecase;

import lombok.Builder;

@Builder(toBuilder = true)
public record AdvertListingUseCase(
        Integer page,
        Integer pageSize,
        String approvalStatusSlug,
        String advertStatusSlug
) {
}
