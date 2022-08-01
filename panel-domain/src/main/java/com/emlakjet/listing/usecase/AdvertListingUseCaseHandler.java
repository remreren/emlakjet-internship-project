package com.emlakjet.listing.usecase;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.listing.port.AdvertListingPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Objects.isNull;

@DomainComponent
@RequiredArgsConstructor
public class AdvertListingUseCaseHandler implements UseCaseHandler<List<Advert>, AdvertListingUseCase> {

    private static final Integer DEFAULT_PAGE_SIZE = 30;

    private static final Integer DEFAULT_PAGE = 0;

    private final AdvertListingPort advertListingPort;

    @Override
    public List<Advert> handle(AdvertListingUseCase useCase) {

        var page = isNull(useCase.page()) ? DEFAULT_PAGE : useCase.page();

        return advertListingPort.getPostsPaging(useCase.toBuilder().page(page).build());

    }
}
