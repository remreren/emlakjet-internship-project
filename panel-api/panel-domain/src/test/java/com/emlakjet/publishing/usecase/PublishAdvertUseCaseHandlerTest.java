package com.emlakjet.publishing.usecase;

import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.port.FakeAdvertEventPort;
import com.emlakjet.advert.port.FakeAdvertPort;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PublishAdvertUseCaseHandlerTest {

    private final AdvertPort advertPort = new FakeAdvertPort();

    private final AdvertEventPort advertEventPort = new FakeAdvertEventPort();

    private final PublishAdvertUseCaseHandler useCaseHandler = new PublishAdvertUseCaseHandler(advertPort, advertEventPort);

    @Test
    void should_handle_publish_advert_status() {

        // Given
        var updateStatusUseCase = new PublishAdvertUseCase(1L);

        // When
        var result = useCaseHandler.handle(updateStatusUseCase);

        // Then
        assertEquals(1L, result.advertId());
        assertEquals(AdvertStatus.NOT_PUBLISHED, result.advertStatus());
        assertEquals(ApprovalStatus.REQUESTED, result.approvalStatus());

    }

}