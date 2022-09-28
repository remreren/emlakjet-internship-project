package com.emlakjet.adapter.listing.rest;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.advert.dto.AdvertResponse;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.listing.usecase.AdvertListingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/listing")
public class AdvertListingController {

    private final UseCaseHandler<List<Advert>, AdvertListingUseCase> advertListingUseCaseHandler;

    private final AdvertMapper mapper;

    @GetMapping(value = {
            "/",
            "/{page:\\d+}",
            "/{approvalSlug}",
            "/{approvalSlug}/{page:\\d+}",
            "/{approvalSlug}/{statusSlug:[a-zA-Z]*}",
            "/{approvalSlug}/{statusSlug:[a-zA-Z]*}/{page:\\d+}",
    })
    public List<AdvertResponse> getAdverts(
            @PathVariable(value = "page", required = false) @Min(1) Integer page,
            @PathVariable(value = "approvalSlug", required = false) String approvalSlug,
            @PathVariable(value = "statusSlug", required = false) String statusSlug,
            @RequestParam(value = "pageSize", required = false, defaultValue = "30") Integer pageSize) {

        var advertListingUsecase = AdvertListingUseCase.builder()
                .approvalStatusSlug(approvalSlug)
                .advertStatusSlug(statusSlug)
                .page(page)
                .pageSize(pageSize)
                .build();

        return advertListingUseCaseHandler.handle(advertListingUsecase)
                                          .parallelStream()
                                          .map(mapper::toAdvertResponse)
                                          .toList();

    }
}
