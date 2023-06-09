package com.example.inventoryservice.contoller;

import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean inStock(@PathVariable("Sku-code") String skucode)
    {
        return new inventoryService.inStock(skucode);

    }
}
