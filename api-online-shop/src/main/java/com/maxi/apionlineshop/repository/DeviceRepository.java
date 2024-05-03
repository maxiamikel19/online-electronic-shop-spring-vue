package com.maxi.apionlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.apionlineshop.models.Device;

public interface DeviceRepository extends JpaRepository<Device, Long>{
    
}
