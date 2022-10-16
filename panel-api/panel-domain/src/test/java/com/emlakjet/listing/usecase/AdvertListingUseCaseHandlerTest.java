package com.emlakjet.listing.usecase;

import com.emlakjet.listing.port.AdvertListingPort;
import com.emlakjet.listing.port.FakeAdvertListingPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvertListingUseCaseHandlerTest {

    private final AdvertListingPort advertListingPort = new FakeAdvertListingPort();
    private final AdvertListingUseCaseHandler useCaseHandler = new AdvertListingUseCaseHandler(advertListingPort);

    @Test
    void should_handle_list_advert() {

        // Given
        var listingUseCase = new AdvertListingUseCase(0, 10, "approved", "published");

        // When
        var result = useCaseHandler.handle(listingUseCase);

        // Then
        assertEquals(1, result.size());

    }
}