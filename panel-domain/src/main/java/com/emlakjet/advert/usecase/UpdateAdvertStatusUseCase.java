package com.emlakjet.advert.usecase;

import com.emlakjet.advert.enums.AdvertStatus;
import com.emlakjet.commons.model.UseCase;

public record UpdateAdvertStatusUseCase(
        Long advertId,
        AdvertStatus status
) implements UseCase {

}
