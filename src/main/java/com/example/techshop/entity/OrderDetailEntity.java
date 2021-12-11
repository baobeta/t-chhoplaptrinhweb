package com.example.techshop.entity;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import lombok.ToString;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@ToString
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @Column(name = "total")
    private int total;

    @Column(name = "ispaid")
    private Boolean ispaid;

    @Column(name = "phone_number",length = 10)
    private String phoneNumber;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name="address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderDetailEntity", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntityList;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private UserEntity userEntity;

}
