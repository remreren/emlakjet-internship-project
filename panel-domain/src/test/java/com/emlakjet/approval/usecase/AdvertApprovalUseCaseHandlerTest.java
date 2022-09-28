package com.emlakjet.approval.usecase;

import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.port.FakeAdvertEventPort;
import com.emlakjet.advert.port.FakeAdvertPort;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.approval.port.AdvertApprovalPort;
import com.emlakjet.approval.port.FakeAdvertApprovalPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvertApprovalUseCaseHandlerTest {

    private final AdvertPort advertPort = new FakeAdvertPort();

    private final AdvertEventPort advertEventPort = new FakeAdvertEventPort();

    private final AdvertApprovalPort approvalPort = new FakeAdvertApprovalPort();

    private final AdvertApprovalUseCaseHandler useCaseHandler = new AdvertApprovalUseCaseHandler(advertPort, approvalPort, advertEventPort);

    @Test
    void should_handle_approve_advert() {

        // Given
        var approvalUseCase = new AdvertApprovalUseCase(1L, ApprovalStatus.APPROVED);

        // When
        var result = useCaseHandler.handle(approvalUseCase);

        // Then
        assertEquals(1L, result.advertId());
        assertEquals(ApprovalStatus.APPROVED, result.approvalStatus());

    }
}