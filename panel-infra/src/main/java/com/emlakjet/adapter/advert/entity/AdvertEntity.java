package com.emlakjet.adapter.advert.entity;

import com.emlakjet.publishing.enums.AdvertStatus;
import com.emlakjet.advert.enums.TradeType;
import com.emlakjet.approval.enums.ApprovalStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Builder(toBuilder = true)
@Entity(name = "advert")
@Table(name = "advert")
@NoArgsConstructor
@AllArgsConstructor
public class AdvertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertId;

    private Long ownerId;

    private String title;

    private String description;

    private BigDecimal price;

    private LocationPointEntity location;

    private TradeType tradeType;

    private IndoorInfoEntity indoorInfo;

    private ApprovalStatus approvalStatus;

    private AdvertStatus advertStatus;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
