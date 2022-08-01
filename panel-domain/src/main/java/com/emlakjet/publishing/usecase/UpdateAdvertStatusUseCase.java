package com.emlakjet.publishing.usecase;

import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.commons.model.UseCase;

public record UpdateAdvertStatusUseCase(
        Long advertId,
        AdvertStatus status
) implements UseCase {

}
