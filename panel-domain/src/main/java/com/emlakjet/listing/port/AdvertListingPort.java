package com.emlakjet.listing.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.listing.usecase.ListingUseCase;

import java.util.List;

public interface AdvertListingPort {

    List<Advert> getPostsPaging(ListingUseCase listingUseCase);
}
