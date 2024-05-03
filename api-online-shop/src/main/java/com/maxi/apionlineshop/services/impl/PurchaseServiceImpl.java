package com.maxi.apionlineshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.apionlineshop.models.Purchase;
import com.maxi.apionlineshop.repository.PurchaseRepository;
import com.maxi.apionlineshop.repository.projection.PurchaseItem;
import com.maxi.apionlineshop.services.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase savePurchase(Purchase purchase) {
        return this.purchaseRepository.save(purchase);
    }

    @Override
    public List<PurchaseItem> findAllPurchaseByUser(Long userId) {
        return this.purchaseRepository.findAllPurchasesByUser(userId);
    }
}
