package com.example.techshop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    public int productId;

    @Getter
    @Setter
    @Column(name = "description")
    public String description;

    @Getter
    @Setter
    @Column(name = "name")
    public String name;

    @Getter
    @Setter
    @Column(name = "price")
    public Integer price;

    @Getter
    @Setter
    @Column(name = "quantity")
    public Integer quantity;

    @Getter
    @Setter
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
    public ProductCategoryEntity productCategoryEntity;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "brand_id")
    public ProductBrandEntity productBrandEntity;
}
