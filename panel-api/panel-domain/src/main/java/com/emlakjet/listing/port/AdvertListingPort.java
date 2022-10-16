package com.emlakjet.listing.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.listing.usecase.AdvertListingUseCase;

import java.util.List;

public interface AdvertListingPort {

    List<Advert> getPostsPaging(AdvertListingUseCase advertListingUseCase);
}
