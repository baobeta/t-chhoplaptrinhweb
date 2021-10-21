package com.example.techshop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    public int brandId;

    @Column(name = "description")
    public String description;

    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy = "productBrandEntity", cascade = CascadeType.ALL)
    public List<ProductEntity> productEntityList;




}
