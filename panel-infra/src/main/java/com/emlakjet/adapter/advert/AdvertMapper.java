package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.advert.entity.AdvertEntity;
import com.emlakjet.adapter.advert.entity.IndoorInfoEntity;
import com.emlakjet.adapter.advert.entity.LocationPointEntity;
import com.emlakjet.adapter.advert.rest.dto.AdvertRequest;
import com.emlakjet.advert.dto.AdvertResponse;
import com.emlakjet.advert.event.AdvertCreatedMessage;
import com.emlakjet.advert.event.AdvertDeletedMessage;
import com.emlakjet.advert.event.AdvertUpdatedMessage;
import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.model.IndoorInfo;
import com.emlakjet.advert.model.LocationPoint;
import com.emlakjet.advert.usecase.CreateAdvertUseCase;
import com.emlakjet.advert.usecase.UpdateAdvertUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdvertMapper {

    Advert toAdvert(AdvertEntity advert);

    AdvertEntity toAdvertEntity(Advert advert);

    AdvertEntity toAdvertEntity(CreateAdvertUseCase useCase);

    AdvertEntity toAdvertEntity(UpdateAdvertUseCase useCase);

    LocationPoint toLocation(LocationPointEntity locationPoint);

    LocationPointEntity toLocationEntity(LocationPoint locationPoint);

    IndoorInfo toIndoorInfo(IndoorInfoEntity indoorInfo);

    IndoorInfoEntity toIndoorInfoEntity(IndoorInfo indoorInfo);

    UpdateAdvertUseCase toUpdateAdvertUseCase(AdvertRequest advert);

    UpdateAdvertUseCase toUpdateAdvertUseCase(AdvertEntity advert);

    CreateAdvertUseCase toCreatePostUseCase(AdvertRequest advert);

    AdvertResponse toAdvertResponse(Advert advert);

    AdvertCreatedMessage toAdvertCreatedMessage(AdvertEntity advert);

    AdvertUpdatedMessage toAdvertUpdatedMessage(AdvertEntity advert);

    AdvertDeletedMessage toAdvertDeletedMessage(Long advertId);
}
