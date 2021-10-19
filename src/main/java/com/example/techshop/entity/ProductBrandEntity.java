package com.example.techshop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_brand")
public class ProductBrandEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_brand_id")
    public int productBrandId;

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
    @OneToMany(mappedBy = "productBrandEntity", cascade = CascadeType.ALL)
    public List<ProductEntity> productEntityList;




}
