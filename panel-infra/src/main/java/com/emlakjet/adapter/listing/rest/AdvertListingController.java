package com.emlakjet.adapter.listing.rest;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.advert.dto.AdvertResponse;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.listing.usecase.ListingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/advert/list")
public class AdvertListingController {

    private final UseCaseHandler<List<Advert>, ListingUseCase> advertListingUsecaseHandler;

    private final AdvertMapper mapper;

    @GetMapping(value = {"", "/{page}"})
    public List<AdvertResponse> getAdverts(
            @PathVariable(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "30") Integer pageSize) {

        return advertListingUsecaseHandler.handle(new ListingUseCase(page, pageSize)).parallelStream().map(mapper::toAdvertResponse).toList();

    }
}
