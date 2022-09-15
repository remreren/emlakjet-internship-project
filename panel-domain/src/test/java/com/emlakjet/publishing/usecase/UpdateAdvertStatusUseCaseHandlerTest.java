package com.emlakjet.publishing.usecase;

import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.port.FakeAdvertEventPort;
import com.emlakjet.advert.port.FakeAdvertPort;
import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.publishing.port.FakeAdvertPublishingPort;
import com.emlakjet.publishing.port.AdvertPublishingPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateAdvertStatusUseCaseHandlerTest {

    private final AdvertPort advertPort = new FakeAdvertPort();

    private final AdvertEventPort advertEventPort = new FakeAdvertEventPort();

    private final AdvertPublishingPort publishingPort = new FakeAdvertPublishingPort();

    private final UpdateAdvertStatusUseCaseHandler useCaseHandler = new UpdateAdvertStatusUseCaseHandler(advertPort, advertEventPort, publishingPort);

    @Test
    void should_handle_update_advert_status() {

        // Given
        var updateStatusUseCase = new UpdateAdvertStatusUseCase(1L, AdvertStatus.NOT_PUBLISHED);

        // When
        var result = useCaseHandler.handle(updateStatusUseCase);

        // Then
        assertEquals(1L, result.advertId());
        assertEquals(AdvertStatus.NOT_PUBLISHED, result.advertStatus());

    }

}