package com.emlakjet.adapter.advert.rest;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.adapter.advert.rest.dto.AdvertRequest;
import com.emlakjet.advert.dto.AdvertResponse;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.usecase.CreateAdvertUseCase;
import com.emlakjet.advert.usecase.UpdateAdvertUseCase;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.commons.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/advert")
public class AdvertController {

    private final UseCaseHandler<Advert, CreateAdvertUseCase> createAdvertUseCaseHandler;

    private final UseCaseHandler<Advert, UpdateAdvertUseCase> updateAdvertUseCaseHandler;

    private final VoidUseCaseHandler<Long> deleteAdvertUseCaseHandler;

    private final AdvertMapper mapper;

    @PutMapping("/")
    public ResponseEntity<AdvertResponse> createAdvert(@RequestBody AdvertRequest advert) {

        var createdPost = createAdvertUseCaseHandler.handle(mapper.toCreatePostUseCase(advert));

        return ResponseEntity.ok(mapper.toAdvertResponse(createdPost));

    }

    @PostMapping("/{advertId}")
    public ResponseEntity<AdvertResponse> updateAdvert(@RequestBody AdvertRequest advert, @PathVariable("advertId") Long advertId) {

        var updatePostUseCase = mapper.toUpdateAdvertUseCase(advert)
                .toBuilder()
                .advertId(advertId)
                .build();

        var updatedPost = updateAdvertUseCaseHandler.handle(updatePostUseCase);

        return ResponseEntity.ok(mapper.toAdvertResponse(updatedPost));

    }

    @DeleteMapping("/{advertId}")
    public ResponseEntity<Boolean> deleteAdvert(@PathVariable("advertId") Long advertId) {

        deleteAdvertUseCaseHandler.handle(advertId);

        return ResponseEntity.ok(Boolean.TRUE);
    }
}
