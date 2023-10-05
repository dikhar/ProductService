package com.example.OrderService.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse
{
    private String skuCode;
    private boolean isInStock;
}
