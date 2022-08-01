package com.emlakjet.publishing.usecase;

import com.emlakjet.commons.model.UseCase;
import com.emlakjet.publishing.enums.AdvertStatus;

public record UpdateAdvertStatusUseCase(
        Long advertId,
        AdvertStatus status
) implements UseCase {

}
