package com.emlakjet.adapter.listing;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.listing.port.AdvertListingPort;
import com.emlakjet.listing.usecase.ListingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class AdvertListingAdapter implements AdvertListingPort {

    private final AdvertRepository advertRepository;

    private final AdvertMapper mapper;

    @Override
    public List<Advert> getPostsPaging(ListingUseCase listingUseCase) {

        var pageable = Pageable.ofSize(listingUseCase.pageSize())
                .withPage(listingUseCase.page());

        return advertRepository.findAll(pageable).map(mapper::toAdvert).toList();
    }
}
