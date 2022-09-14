package com.emlakjet.approval.usecase;

import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.approval.port.AdvertApprovalPort;
import com.emlakjet.approval.port.FakeAdvertApprovalPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvertApprovalUseCaseHandlerTest {

    private final AdvertApprovalPort approvalPort = new FakeAdvertApprovalPort();
    private final AdvertApprovalUseCaseHandler useCaseHandler = new AdvertApprovalUseCaseHandler(approvalPort);

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