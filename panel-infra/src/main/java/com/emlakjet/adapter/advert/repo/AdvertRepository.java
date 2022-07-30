package com.emlakjet.adapter.advert.repo;

import com.emlakjet.adapter.advert.entity.AdvertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<AdvertEntity, Long> {
}
