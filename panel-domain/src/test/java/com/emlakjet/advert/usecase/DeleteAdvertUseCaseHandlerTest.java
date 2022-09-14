package com.emlakjet.advert.usecase;

import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.port.FakeAdvertPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteAdvertUseCaseHandlerTest {

    private final AdvertPort advertPort = new FakeAdvertPort();
    private final DeleteAdvertUseCaseHandler useCaseHandler = new DeleteAdvertUseCaseHandler(advertPort);


    @Test
    void should_handle_delete_advert() {

        // Given
        // DoNothing

        // When
        useCaseHandler.handle(1L);

        // Then
        assertNotNull(useCaseHandler);

    }

}