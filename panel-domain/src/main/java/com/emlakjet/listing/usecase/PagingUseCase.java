package com.emlakjet.listing.usecase;

import lombok.Builder;

@Builder(toBuilder = true)
public record PagingUseCase(Integer page, Integer pageSize) {
}
