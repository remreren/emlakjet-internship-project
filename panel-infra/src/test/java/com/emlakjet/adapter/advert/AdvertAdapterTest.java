package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.advert.repo.AdvertRepository;
import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdvertAdapterTest {

    private final AdvertRepository advertRepository = Mockito.mock(AdvertRepository.class);

    private final AdvertMapper mapper = Mappers.getMapper(AdvertMapper.class);

    private final AdvertAdapter advertAdapter = new AdvertAdapter(advertRepository, mapper);

    @Test
    void should_create_advert() {

        // Given
        var location = new LocationPoint(34D, 42D);
        var indoorInfo = new IndoorInfo(90, 80, "1+1", 6, 2);
        var createAdvert = new Advert(1L, "Title", "Description", BigInteger.valueOf(1000L), location, TradeType.SALE, indoorInfo, ApprovalStatus.REQUESTED, AdvertStatus.HANG, new Date(), new Date());
        var createdAdvertEntity = mapper.toAdvertEntity(createAdvert);

        when(advertRepository.save(createdAdvertEntity)).thenReturn(createdAdvertEntity);

        // When
        var result = advertAdapter.createAdvert(createAdvert);

        // Then
        assertEquals("Title", result.title());
        assertEquals("Description", result.description());
        assertEquals(location, result.location());
        assertEquals(indoorInfo, result.indoorInfo());

        verify(advertRepository, times(1)).save(createdAdvertEntity);

    }

    @Test
    void should_update_advert() {

        // Given
        var location = new LocationPoint(34D, 42D);
        var indoorInfo = new IndoorInfo(90, 80, "1+1", 6, 2);
        var createAdvert = new Advert(1L, "Title", "Description", BigInteger.valueOf(1000L), location, TradeType.SALE, indoorInfo, ApprovalStatus.REQUESTED, AdvertStatus.HANG, new Date(), new Date());
        var createdAdvertEntity = mapper.toAdvertEntity(createAdvert);

        when(advertRepository.save(createdAdvertEntity)).thenReturn(createdAdvertEntity);

        // When
        var result = advertAdapter.createAdvert(createAdvert);

        // Then
        assertEquals("Title", result.title());
        assertEquals("Description", result.description());
        assertEquals(location, result.location());
        assertEquals(indoorInfo, result.indoorInfo());

        verify(advertRepository, times(1)).save(createdAdvertEntity);

    }

    @Test
    void should_delete_advert() {

        // Given
        var advertId = 45345L;
        doNothing().when(advertRepository).deleteById(advertId);

        // When
        advertAdapter.deleteAdvert(advertId);

        // Then
        verify(advertRepository, times(1)).deleteById(advertId);

    }

}