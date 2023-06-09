package com.rest.Orderservice.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReq {
    private List<OrderLineItemDto> orderLineItemDtoList;
}
