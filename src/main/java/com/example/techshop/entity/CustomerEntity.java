package com.example.techshop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public int customerId;


    @Getter
    @Setter
    @Column(name = "first_name")
    public String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    public String lastName;

    @Getter
    @Setter
    @Column(name = "email")
    public String email;

    @Getter
    @Setter
    @Column(name = "password")
    public String password;

    @Getter
    @Setter
    @Column(name = "phone_number")
    public String phoneNumber;

    @Getter
    @Setter
    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    public List<OrderDetailEntity> orderDetailEntityList;

    @Getter
    @Setter
    @OneToOne // Đánh dấu có mỗi quan hệ 1-1 với Person ở phía dưới
    @JoinColumn(name = "cus_id") // Liên kết với nhau qua khóa ngoại users_id
    public ShoppingSessionEntity sessionEntity;

}
