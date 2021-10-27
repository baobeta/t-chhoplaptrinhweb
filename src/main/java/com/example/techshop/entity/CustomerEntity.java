package com.example.techshop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import lombok.ToString;


@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public int customerId;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "phone_number")
    public String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerEntity", cascade = CascadeType.ALL)
    public List<OrderDetailEntity> orderDetailEntityList;

}
