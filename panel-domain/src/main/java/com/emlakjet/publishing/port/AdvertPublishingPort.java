package com.emlakjet.publishing.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.publishing.usecase.UpdateAdvertStatusUseCase;

public interface AdvertPublishingPort {

    Advert updateAdvertStatus(UpdateAdvertStatusUseCase advert);

}
