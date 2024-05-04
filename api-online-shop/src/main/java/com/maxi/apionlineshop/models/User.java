package com.maxi.apionlineshop.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.maxi.apionlineshop.models.enums.Role;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private LocalDate createDate;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String token;

    // @OneToMany(mappedBy = "user")
    // private List<Purchase> purchases;
}
