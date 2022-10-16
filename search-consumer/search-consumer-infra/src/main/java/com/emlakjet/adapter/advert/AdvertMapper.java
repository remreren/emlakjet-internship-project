package com.emlakjet.adapter.advert;

import com.emlakjet.adapter.listener.AdvertEntity;
import com.emlakjet.advert.model.Advert;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdvertMapper {

    Advert toAdvert(AdvertEntity advertEntity);

}
