package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_details")
public class OrderDetailEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    public int orderDetailsId;

    @Getter
    @Setter
    @Column(name = "total")
    public Long total;

    @Getter
    @Setter
    @Column(name = "ispaid")
    public Boolean ispaid;


    @OneToMany(mappedBy = "orderDetailEntity", cascade = CascadeType.ALL)
    public List<OrderItemEntity> orderItemEntityList;

    @ManyToOne
    @JoinColumn(name = "seller")
    public UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    public CustomerEntity customerEntity;

}
