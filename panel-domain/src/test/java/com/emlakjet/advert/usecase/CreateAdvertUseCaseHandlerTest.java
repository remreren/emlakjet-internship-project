package com.emlakjet.advert.usecase;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.port.FakeAdvertPort;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class CreateAdvertUseCaseHandlerTest {

    private final AdvertPort advertPort = new FakeAdvertPort();
    private final CreateAdvertUseCaseHandler useCaseHandler = new CreateAdvertUseCaseHandler(advertPort);

    @Test
    void should_handle_create_advert() {

        // Given
        var location = new LocationPoint(34D, 42D);
        var indoor = new IndoorInfo(90, 90, "2+1", 5, 2);
        var createAdvertUseCase = CreateAdvertUseCase.builder()
                .title("Title")
                .description("Description")
                .ownerId(1L)
                .price(new BigInteger("10000"))
                .tradeType(TradeType.SALE)
                .location(location)
                .indoorInfo(indoor)
                .build();

        // When
        var result = useCaseHandler.handle(createAdvertUseCase);

        // Then
        assertEquals(location, result.location());
        assertEquals(indoor, result.indoorInfo());
        assertEquals("Title", result.title());
        assertEquals("Description", result.description());
        assertEquals(TradeType.SALE, result.tradeType());

    }
}