package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_items_id")
    public int orderItemsId;

    @Getter
    @Setter
    @Column(name = "quantiy")
    public Integer quantiy;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "product_id")
    public ProductEntity productEntity;



    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "order_id")
    public OrderDetailEntity orderDetailEntity;

    @Getter
    @Setter
    @OneToOne // Đánh dấu có mỗi quan hệ 1-1 với Person ở phía dưới
    @JoinColumn(name = "users_id") // Liên kết với nhau qua khóa ngoại users_id
    public UserEntity user;



}
