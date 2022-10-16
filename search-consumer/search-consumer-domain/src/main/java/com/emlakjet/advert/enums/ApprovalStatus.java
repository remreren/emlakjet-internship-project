package com.emlakjet.advert.enums;

import com.emlakjet.advert.exception.ApprovalStatusNotFoundException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ApprovalStatus {

    APPROVED("approved"),
    REQUESTED("requested"),
    REJECTED("rejected");

    private final String slug;

    public static ApprovalStatus findBySlug(@NonNull String slug) {
        return Arrays.stream(values()).filter(stat -> stat.slug.equals(slug)).findFirst().orElseThrow(ApprovalStatusNotFoundException::new);
    }
}
