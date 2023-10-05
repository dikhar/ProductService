package com.example.OrderService.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest  {
    private List<OrderLineDto> orderLineDtoList;
}
