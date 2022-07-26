package com.emlakjet.adapter.post.entity;

import com.emlakjet.post.enums.TradeType;
import com.emlakjet.post.model.IndoorInfo;
import com.emlakjet.post.model.LocationPoint;
import com.emlakjet.post.model.Post;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import static java.util.Objects.isNull;

@Setter
@Getter
@Builder
@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private Long ownerId;

    private String title;

    private String description;

    private BigDecimal price;

    private LocationPointEntity location;

    private TradeType tradeType;

    private IndoorInfoEntity indoorInfo;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Post toPost() {

        var locationPoint = isNull(getLocation()) ? null : new LocationPoint(
                location.lat(),
                location.lng());

        var indoor = isNull(getIndoorInfo()) ? null : new IndoorInfo(
                indoorInfo.squareMeter(),
                indoorInfo.netSquareMeter(),
                indoorInfo.roomCount(),
                indoorInfo.floorCount(),
                indoorInfo.floorNumber());

        return new Post(
                postId,
                title,
                description,
                price,
                locationPoint,
                tradeType,
                indoor,
                createdAt,
                updatedAt);
    }
}
