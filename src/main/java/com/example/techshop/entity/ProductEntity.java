package com.example.techshop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public int productId;

    @Column(name = "description")
    public String description;

    @Column(name = "name")
    public String name;

    @Column(name = "price")
    public Integer price;

    @Column(name = "quantity")
    public Integer quantity;

    @Column(name = "photo")
    public String photo;

    @Getter
    @Setter
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    public List<CartItemEntity> cartItemEntityList;

    @Getter
    @Setter
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    public List<OrderItemEntity> orderItemEntityList;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id")
    public CategoryEntity productCategoryEntity;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "brand_id")
    public BrandEntity productBrandEntity;
}
