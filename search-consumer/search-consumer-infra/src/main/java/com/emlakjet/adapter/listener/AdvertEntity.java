package com.emlakjet.adapter.listener;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "advert")
@Table(name = "advert")
public class AdvertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertId;

    private Long ownerId;

    private String title;

    private String description;

    private BigInteger price;

    @Embedded
    private LocationPointEntity location;

    @Embedded
    private IndoorInfoEntity indoorInfo;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}