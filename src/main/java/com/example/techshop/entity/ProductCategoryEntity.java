package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_category")
public class ProductCategoryEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    public int productCategoryId;

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
    @OneToMany(mappedBy = "productCategoryEntity", cascade = CascadeType.ALL)
    public List<ProductEntity> productEntityList;


}
