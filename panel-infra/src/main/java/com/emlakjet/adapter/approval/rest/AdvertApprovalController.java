package com.emlakjet.adapter.approval.rest;

import com.emlakjet.adapter.advert.AdvertMapper;
import com.emlakjet.advert.dto.AdvertResponse;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.approval.usecase.AdvertApprovalUseCase;
import com.emlakjet.commons.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/approval/advert")
public class AdvertApprovalController {

    private final UseCaseHandler<Advert, AdvertApprovalUseCase> advertApprovalUseCaseHandler;

    private final AdvertMapper mapper;

    @PostMapping("/{advertId}/approve")
    public ResponseEntity<AdvertResponse> approveAdvert(@PathVariable("advertId") Long advertId) {

        var advert = advertApprovalUseCaseHandler.handle(new AdvertApprovalUseCase(advertId, ApprovalStatus.APPROVED));

        return ResponseEntity.ok(mapper.toAdvertResponse(advert));

    }

    @PostMapping("/{advertId}/reject")
    public ResponseEntity<AdvertResponse> rejectAdvert(@PathVariable("advertId") Long advertId) {

        var advert = advertApprovalUseCaseHandler.handle(new AdvertApprovalUseCase(advertId, ApprovalStatus.REJECTED));

        return ResponseEntity.ok(mapper.toAdvertResponse(advert));

    }
}
