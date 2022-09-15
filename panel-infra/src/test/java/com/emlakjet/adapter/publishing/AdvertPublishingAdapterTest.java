package com.emlakjet.adapter.publishing;

import com.emlakjet.adapter.advert.AdvertMapper;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdvertPublishingAdapterTest {

    private final AdvertRepository advertRepository = Mockito.mock(AdvertRepository.class);

    private final AdvertMapper advertMapper = Mappers.getMapper(AdvertMapper.class);

    private final AdvertPublishingAdapter advertPublishingAdapter = new AdvertPublishingAdapter(advertRepository, advertMapper);

    @Test
    void should_publish_advert() {

        // Given
        var location = new LocationPoint(34D, 42D);
        var indoorInfo = new IndoorInfo(90, 80, "1+1", 6, 2);
        var advert = new Advert(1L, "Title", "Description", BigInteger.valueOf(1000L), location, TradeType.SALE, indoorInfo, ApprovalStatus.APPROVED, AdvertStatus.PUBLISHED, new Date(), new Date());
        var updatedAdvertEntity = advertMapper.toAdvertEntity(advert);

        when(advertRepository.save(updatedAdvertEntity)).thenReturn(updatedAdvertEntity);

        // When
        var result = advertPublishingAdapter.updateAdvertStatus(advert);

        // Then
        assertEquals(advert, result);

        verify(advertRepository, times(1)).save(updatedAdvertEntity);

    }

}