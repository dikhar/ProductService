package com.example.InventoryService.repo;

import com.example.InventoryService.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface    InventoryRepo extends JpaRepository<Inventory,Integer> {

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
