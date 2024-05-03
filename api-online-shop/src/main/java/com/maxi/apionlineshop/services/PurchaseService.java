package com.maxi.apionlineshop.services;

import java.util.List;

import com.maxi.apionlineshop.models.Purchase;
import com.maxi.apionlineshop.repository.projection.PurchaseItem;

public interface PurchaseService {
    
    Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findAllPurchaseByUser(Long userId);
}
