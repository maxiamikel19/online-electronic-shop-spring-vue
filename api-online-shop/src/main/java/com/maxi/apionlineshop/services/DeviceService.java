package com.maxi.apionlineshop.services;

import java.util.List;

import com.maxi.apionlineshop.models.Device;

public interface DeviceService {
    
    Device saveDevice(Device device);

    void deleteDeviceById(Long id);

    List<Device> findAllDevices();
}
