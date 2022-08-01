package com.emlakjet.adapter.publishing.rest;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.advert.dto.AdvertResponse;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.publishing.usecase.UpdateAdvertStatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/publishing/advert")
public class AdvertPublishingController {

    private final UseCaseHandler<Advert, UpdateAdvertStatusUseCase> updateAdvertStatusUseCaseHandler;

    private final AdvertMapper mapper;

    @PostMapping("/{advertId}/publish/")
    public ResponseEntity<AdvertResponse> publishAdvert(@PathVariable("advertId") Long advertId) {

        var advert = updateAdvertStatusUseCaseHandler.handle(new UpdateAdvertStatusUseCase(advertId, AdvertStatus.PUBLISHED));

        return ResponseEntity.ok(mapper.toAdvertResponse(advert));

    }

    @PostMapping("/{advertId}/unpublish/")
    public ResponseEntity<AdvertResponse> unpublishAdvert(@PathVariable("advertId") Long advertId) {

        var advert = updateAdvertStatusUseCaseHandler.handle(new UpdateAdvertStatusUseCase(advertId, AdvertStatus.NOT_PUBLISHED));

        return ResponseEntity.ok(mapper.toAdvertResponse(advert));

    }
}
