package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.advert.entity.AdvertEntity;
import com.emlakjet.adapter.advert.entity.IndoorInfoEntity;
import com.emlakjet.adapter.advert.entity.LocationPointEntity;
import com.emlakjet.adapter.advert.rest.dto.AdvertRequest;
import com.emlakjet.advert.dto.AdvertResponse;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.advert.usecase.CreateAdvertUseCase;
import com.emlakjet.advert.usecase.UpdateAdvertUseCase;
import com.emlakjet.advert.event.AdvertCreatedEvent;
import com.emlakjet.advert.event.AdvertUpdatedEvent;
import com.emlakjet.advert.event.AdvertDeletedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdvertMapper {

    Advert toAdvert(AdvertEntity advert);

    AdvertEntity toAdvertEntity(Advert advert);

    AdvertEntity toAdvertEntity(CreateAdvertUseCase useCase);

    @Mapping(target = "advertId", source = "entity.advertId")
    @Mapping(target = "ownerId", source = "entity.ownerId")
    @Mapping(target = "title", source = "updated.title")
    @Mapping(target = "description", source = "updated.description")
    @Mapping(target = "price", source = "updated.price")
    @Mapping(target = "location", source = "updated.location")
    @Mapping(target = "tradeType", source = "updated.tradeType")
    @Mapping(target = "indoorInfo", source = "updated.indoorInfo")
    AdvertEntity toAdvertEntity(AdvertEntity entity, UpdateAdvertUseCase updated);

    LocationPoint toLocation(LocationPointEntity locationPoint);

    LocationPointEntity toLocationEntity(LocationPoint locationPoint);

    IndoorInfo toIndoorInfo(IndoorInfoEntity indoorInfo);

    IndoorInfoEntity toIndoorInfoEntity(IndoorInfo indoorInfo);

    UpdateAdvertUseCase toUpdateAdvertUseCase(AdvertRequest advert);

    UpdateAdvertUseCase toUpdateAdvertUseCase(AdvertEntity advert);

    CreateAdvertUseCase toCreatePostUseCase(AdvertRequest advert);

    AdvertResponse toAdvertResponse(Advert advert);

    AdvertCreatedEvent toAdvertCreatedMessage(AdvertEntity advert);

    AdvertUpdatedEvent toAdvertUpdatedMessage(AdvertEntity advert);

    AdvertDeletedEvent toAdvertDeletedMessage(Long advertId);
}
