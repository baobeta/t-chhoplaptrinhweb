package com.example.techshop.entity;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import lombok.ToString;


@Entity
@Table(name = "cart_items")
@Getter
@Setter
@ToString
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int cartItemId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private ShoppingSessionEntity shoppingSessionEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Column(name = "createdDate")
    private Timestamp createdDate;

}
