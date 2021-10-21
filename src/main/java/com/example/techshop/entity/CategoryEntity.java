package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public int categoryId;

    @Column(name = "description")
    public String description;

    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy = "productCategoryEntity", cascade = CascadeType.ALL)
    public List<ProductEntity> productEntityList;


}
