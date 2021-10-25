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
    private int orderItemsId;

    @Column(name = "quantiy")
    private Integer quantiy;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDetailEntity orderDetailEntity;

    @OneToOne(cascade = CascadeType.ALL) // Đánh dấu có mỗi quan hệ 1-1 với Person ở phía dưới
    @JoinColumn(name = "cus_id", referencedColumnName = "customer_id") // Liên kết với nhau qua khóa ngoại users_id
    private CustomerEntity customerEntity;

}
