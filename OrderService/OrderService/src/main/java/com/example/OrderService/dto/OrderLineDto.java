package com.example.OrderService.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderLineDto {
    private Integer id;
    private String skucode;
    private Integer price;
    private Integer quantity;
}
