package com.example.InventoryService.sevice;

import com.example.InventoryService.dto.InventoryResponse;
import com.example.InventoryService.entity.Inventory;
import com.example.InventoryService.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private WebClient webClient;
    public void saveInventory(Inventory inventory)
    {
        inventoryRepo.save(inventory);
    }

    public List<Inventory> getInventory()
    {
        return inventoryRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> getSkuInventory(List<String> skuCode)
    {
        return inventoryRepo.findBySkuCodeIn(skuCode).stream().map(Inventory -> InventoryResponse.builder()
                .skuCode(Inventory.getSkuCode()).
                isInStock(Inventory.getQuantity()>0)
                .build()).toList();
    }
}
