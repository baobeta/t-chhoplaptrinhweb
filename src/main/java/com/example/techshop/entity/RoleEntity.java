package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import lombok.ToString;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roleEntity",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<UserEntity> userEntityList;

    @Override
    public String toString() {
        return this.name;
    }
}
