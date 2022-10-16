package com.emlakjet.publishing.enums;

import com.emlakjet.publishing.exception.AdvertStatusNotFoundException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum AdvertStatus {
    PUBLISHED("published"),
    NOT_PUBLISHED("unpublished"),
    HANG("hang");

    private final String slug;

    public static AdvertStatus findBySlug(@NonNull String slug) {
        return Arrays.stream(values()).filter(stat -> stat.slug.equals(slug)).findFirst().orElseThrow(AdvertStatusNotFoundException::new);
    }
}
