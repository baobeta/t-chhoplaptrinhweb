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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_session_id")
    private int shoppingSessionId;

    @Column(name = "total")
    private Long total;

    @OneToOne(cascade = CascadeType.ALL) // Đánh dấu có mỗi quan hệ 1-1 với Person ở phía dưới
    @JoinColumn(name = "cus_id", referencedColumnName = "customer_id") // Liên kết với nhau qua khóa ngoại users_id
    private CustomerEntity customerEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingSessionEntity", cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItemEntityList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
    List<OrderDetailEntity> orderDetailEntityList;
}
