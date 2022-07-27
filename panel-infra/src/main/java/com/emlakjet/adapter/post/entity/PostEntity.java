package com.emlakjet.adapter.post.entity;

import com.emlakjet.approval.enums.ApprovalStatus;
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
@Entity(name = "post")
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

    private ApprovalStatus approvalStatus;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
