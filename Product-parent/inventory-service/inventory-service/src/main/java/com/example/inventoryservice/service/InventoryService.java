package com.example.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final Repository repository;
    public boolean inStock(String skucode)
    {
        return repository.findBySkuCode().isPresent();
    }
}
