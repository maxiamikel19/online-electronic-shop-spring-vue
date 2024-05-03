package com.maxi.apionlineshop.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "devices")
public class Device {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    // private Set<Purchase> purchases;
}
