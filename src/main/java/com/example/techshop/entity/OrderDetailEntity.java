package com.example.techshop.entity;

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
    private Integer orderDetailsId;

    @Column(name = "total")
    private Integer total;

    @Column(name = "ispaid")
    private Boolean ispaid;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderDetailEntity", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntityList;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private UserEntity userEntity;

}
