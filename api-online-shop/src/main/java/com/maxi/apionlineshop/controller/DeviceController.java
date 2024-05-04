package com.maxi.apionlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.apionlineshop.models.Device;
import com.maxi.apionlineshop.services.DeviceService;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
    
    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<?> saveDevice(@RequestBody Device device){
        return new ResponseEntity<>(this.deviceService.saveDevice(device), HttpStatus.CREATED);
    }

    @DeleteMapping("{deviceId}")
    public ResponseEntity<?> deleteDevice(@PathVariable Long deviceId){
        this.deviceService.deleteDeviceById(deviceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllDevices(){
        return new ResponseEntity<>(this.deviceService.findAllDevices(), HttpStatus.OK);
    }
}
