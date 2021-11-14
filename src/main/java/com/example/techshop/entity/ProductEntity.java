package com.example.techshop.entity;


import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "photo")
    private String photo;

    @Column(name= "is_sale")
    private boolean isSale;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItemEntityList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntityList;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;
}
