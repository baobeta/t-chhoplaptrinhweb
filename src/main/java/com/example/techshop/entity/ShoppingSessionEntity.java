package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import lombok.ToString;

@Entity
@Table(name = "shopping_session")
@Getter
@Setter
@ToString
public class ShoppingSessionEntity {

    @Id
    @Column(name = "cus_id")
    private Integer shoppingSessionId;

    @Column(name = "total")
    private int total;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cus_id")
    private UserEntity userEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingSessionEntity", cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItemEntityList;
}
