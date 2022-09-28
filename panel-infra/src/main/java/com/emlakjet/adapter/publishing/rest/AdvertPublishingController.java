package com.emlakjet.adapter.publishing.rest;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.advert.dto.AdvertResponse;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.publishing.usecase.PublishAdvertUseCase;
import com.emlakjet.publishing.usecase.UnPublishAdvertUseCase;
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

    private final UseCaseHandler<Advert, PublishAdvertUseCase> publishAdvertUseCaseHandler;
    private final UseCaseHandler<Advert, UnPublishAdvertUseCase> unPublishAdvertUseCaseHandler;

    private final AdvertMapper mapper;

    @PostMapping("/{advertId}/publish")
    public ResponseEntity<AdvertResponse> publishAdvert(@PathVariable("advertId") Long advertId) {

        var advert = publishAdvertUseCaseHandler.handle(new PublishAdvertUseCase(advertId));

        return ResponseEntity.ok(mapper.toAdvertResponse(advert));

    }

    @PostMapping("/{advertId}/unpublish") // TODO: naming convention
    public ResponseEntity<AdvertResponse> unPublishAdvert(@PathVariable("advertId") Long advertId) {

        var advert = unPublishAdvertUseCaseHandler.handle(new UnPublishAdvertUseCase(advertId));

        return ResponseEntity.ok(mapper.toAdvertResponse(advert));

    }
}
