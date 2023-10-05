package com.example.InventoryService.contoller;

import com.example.InventoryService.dto.InventoryResponse;
import com.example.InventoryService.entity.Inventory;
import com.example.InventoryService.sevice.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    private ResponseEntity<Inventory> createIn(@RequestBody Inventory inventory)
    {
        inventoryService.saveInventory(inventory);
        return ResponseEntity.status(HttpStatus.OK).body(inventory);
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<Inventory>> getIn()
    {
        List<Inventory> inventory=inventoryService.getInventory();
        return ResponseEntity.ok().body(inventory);
    }
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    private List<InventoryResponse> getSkuIn(@RequestParam List<String> skuCode)
    {
        return inventoryService.getSkuInventory(skuCode);
    }
}
