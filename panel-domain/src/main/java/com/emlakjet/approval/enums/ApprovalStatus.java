package com.emlakjet.approval.enums;

import com.emlakjet.approval.exception.ApprovalStatusNotFoundException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

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
