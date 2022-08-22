package com.emlakjet.adapter.advert.repo;

import com.emlakjet.adapter.advert.entity.AdvertEntity;
import com.emlakjet.adapter.advert.entity.IndoorInfoEntity;
import com.emlakjet.adapter.advert.entity.LocationPointEntity;
import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.publishing.enums.AdvertStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
class AdvertRepositoryTest {

    @Container
    private static final PostgreSQLContainer<?> database = new PostgreSQLContainer<>("postgres:latest");

    @Autowired
    private AdvertRepository advertRepository;

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",database::getJdbcUrl);
        registry.add("spring.datasource.username", database::getUsername);
        registry.add("spring.datasource.password", database::getPassword);

    }

    @Test
    void should_insert_advert() {

        // Given
        var indoorInfo = new IndoorInfoEntity(100, 80, "1+1", 10, 3);
        var advert = new AdvertEntity(1L, 1L, "Title", "Description", BigDecimal.TEN, new LocationPointEntity(34D, 34D),
                                      TradeType.SALE, indoorInfo, ApprovalStatus.REQUESTED, AdvertStatus.NOT_PUBLISHED, new Date(), new Date());

        // When
        var result = advertRepository.save(advert);

        // Then
        assertEquals(advert.toString(), result.toString());

    }

}