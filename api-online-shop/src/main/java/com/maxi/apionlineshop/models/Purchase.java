package com.maxi.apionlineshop.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "purchases")
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long userId;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    //private Long deviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id" , referencedColumnName = "id", insertable = false, updatable = false)
    private Device device;

    private Double price;

    private String color;

    private LocalDateTime createTime;
}
