package com.maxi.apionlineshop.repository.projection;

import java.time.LocalDateTime;

import com.maxi.apionlineshop.models.DeviceType;

public interface PurchaseItem {
    String getName();
    DeviceType getType();
    String getColor();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
