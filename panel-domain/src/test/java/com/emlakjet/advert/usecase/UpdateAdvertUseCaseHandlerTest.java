package com.emlakjet.advert.usecase;

import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.advert.port.AdvertPort;
import com.emlakjet.advert.port.FakeAdvertPort;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class UpdateAdvertUseCaseHandlerTest {

    private final AdvertPort advertPort = new FakeAdvertPort();
    private final UpdateAdvertUseCaseHandler useCaseHandler = new UpdateAdvertUseCaseHandler(advertPort);

    @Test
    void should_handle_update_advert() {

        // Given
        var location = new LocationPoint(36D, 40D);
        var indoorInfo = new IndoorInfo(60, 50, "2+1", 5, 2);
        var updateAdvert = UpdateAdvertUseCase.builder()
                .advertId(1L)
                .ownerId(1L)
                .title("Title2")
                .description("Description2")
                .price(BigInteger.valueOf(2000L))
                .location(location)
                .tradeType(TradeType.SALE)
                .indoorInfo(indoorInfo)
                .build();

        // When
        var result = useCaseHandler.handle(updateAdvert);

        // Then
        assertEquals("Title2", result.title());
        assertEquals("Description2", result.description());
        assertEquals(BigInteger.valueOf(2000L), result.price());
        assertEquals(location, result.location());
        assertEquals(indoorInfo, result.indoorInfo());

    }
}