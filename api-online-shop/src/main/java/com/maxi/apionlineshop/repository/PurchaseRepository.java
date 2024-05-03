package com.maxi.apionlineshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maxi.apionlineshop.models.Purchase;
import com.maxi.apionlineshop.repository.projection.PurchaseItem;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
    
    @Query("select " + 
            "d.name as name, d.deviceType as type, p.price as price, p.color as color, p.createTime as purchaseTime " + 
            "from Purchase p left join Device d on d.id = p.deviceId " + 
            "where p.userId = :userId")
    List<PurchaseItem> findAllPurchasesByUser(@Param("userId") Long userId);
}
