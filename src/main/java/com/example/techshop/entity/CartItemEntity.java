package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "cart_item")
public class CartItemEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    public int cartItemId;

    @Getter
    @Setter
    @Column(name = "quantity")
    public Integer quantity;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "session_id")
    public ShoppingSessionEntity shoppingSessionEntity;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "product_id")
    public ProductEntity productEntity;



}
