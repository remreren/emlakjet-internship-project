package com.emlakjet.advert.usecase;

import com.emlakjet.advert.port.AdvertEventPort;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.port.FakeAdvertEventPort;
import com.emlakjet.advert.port.FakeAdvertPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteAdvertUseCaseHandlerTest {

    private final AdvertPort advertPort = new FakeAdvertPort();

    private final AdvertEventPort advertEventPort = new FakeAdvertEventPort();

    private final DeleteAdvertUseCaseHandler useCaseHandler = new DeleteAdvertUseCaseHandler(advertPort, advertEventPort);


    @Test
    void should_handle_delete_advert() {

        // Given
        var deleteAdvertUseCase = new DeleteAdvertUseCase(1L);

        // When
        useCaseHandler.handle(deleteAdvertUseCase);

        // Then
        assertNotNull(useCaseHandler);

    }

}