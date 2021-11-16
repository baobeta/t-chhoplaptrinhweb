package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@ToString
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDetailEntity orderDetailEntity;

}
