package com.maxi.apionlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.apionlineshop.config.UserPrincipal;
import com.maxi.apionlineshop.models.Purchase;
import com.maxi.apionlineshop.services.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>(this.purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchaseOfAnUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return new ResponseEntity<>(this.purchaseService.findAllPurchaseByUser(userPrincipal.getId()), HttpStatus.OK);
    }
}
