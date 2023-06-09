package com.rest.Orderservice.orderservice.controller;

import com.rest.Orderservice.orderservice.dto.OrderReq;
import com.rest.Orderservice.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String orderplace(@RequestBody OrderReq orderreq)
    {
        orderService.placeOrder(orderreq);
        return "order placed successfully";
    }
}
