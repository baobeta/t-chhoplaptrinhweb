package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping_session")
public class ShoppingSessionEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_session_id")
    public int shoppingSessionId;

    @Getter
    @Setter
    @Column(name = "total")
    public Long total;

    @Getter
    @Setter
    @OneToOne // Đánh dấu có mỗi quan hệ 1-1 với Person ở phía dưới
    @JoinColumn(name = "cus_id") // Liên kết với nhau qua khóa ngoại users_id
    public CustomerEntity customerEntity;

    @Getter
    @Setter
    @OneToMany(mappedBy = "shoppingSessionEntity", cascade = CascadeType.ALL)
    public List<CartItemEntity> cartItemEntityList;

    @Getter
    @Setter
    @OneToMany(mappedBy = "userEntity",fetch = FetchType.LAZY)
    List<OrderDetailEntity> orderDetailEntityList;
}
