package com.example.techshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class UserEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    @Getter
    @Setter
    @Column(length =128, nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(length =64, nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(name="first_name", length =45 , nullable =false)
    private String firstName;

    @Getter
    @Setter
    @Column(name="last_name", length =45 , nullable =false)
    private String lastName;

    @Getter
    @Setter
    @Column( length =64 )
    private String photos;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
}
