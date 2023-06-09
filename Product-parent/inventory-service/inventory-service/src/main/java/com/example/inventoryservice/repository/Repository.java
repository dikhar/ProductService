package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<inventory,Integer> {
    void findBySkuCode();
}
