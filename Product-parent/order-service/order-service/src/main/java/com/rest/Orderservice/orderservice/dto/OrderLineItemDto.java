package com.rest.Orderservice.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class   OrderLineItemDto {
    private Long id;
    private String skuCode;
    private BigInteger price;
    private Integer quantity;
}
