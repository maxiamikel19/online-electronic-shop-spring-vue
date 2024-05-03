package com.maxi.apionlineshop.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.apionlineshop.models.Device;
import com.maxi.apionlineshop.repository.DeviceRepository;
import com.maxi.apionlineshop.services.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{
    
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device saveDevice(Device device){
        device.setCreateDate(LocalDate.now());
        return this.deviceRepository.save(device);
    }

    @Override
    public void deleteDeviceById(Long id) {
       this.deviceRepository.deleteById(id);
    }

    @Override
    public List<Device> findAllDevices() {
        return this.deviceRepository.findAll();
    }
}
