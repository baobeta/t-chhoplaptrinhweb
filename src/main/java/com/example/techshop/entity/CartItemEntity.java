package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "cart_item")
@Getter
@Setter
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    public int cartItemId;

    @Column(name = "quantity")
    public Integer quantity;

    @ManyToOne
    @JoinColumn(name = "session_id")
    public ShoppingSessionEntity shoppingSessionEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public ProductEntity productEntity;



}
