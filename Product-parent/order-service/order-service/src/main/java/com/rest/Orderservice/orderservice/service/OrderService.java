package com.rest.Orderservice.orderservice.service;

import com.rest.Orderservice.orderservice.dto.OrderLineItemDto;
import com.rest.Orderservice.orderservice.dto.OrderReq;
import com.rest.Orderservice.orderservice.model.order;
import com.rest.Orderservice.orderservice.model.OrderLineItem;
import com.rest.Orderservice.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderReq orderReq){
        order Order=new order();
        Order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = orderReq.getOrderLineItemDtoList().stream().map(this::mapTODto).toList();
        Order.setOrderLineItem(orderLineItems);
        orderRepository.save(Order);
    }
    private OrderLineItem mapTODto(OrderLineItemDto orderLineItemDto)
    {
        OrderLineItem orderLineItem =new OrderLineItem();
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        orderLineItem.setSkuCode(orderLineItem.getSkuCode());
        return orderLineItem;
    }
}
