package com.example.OrderService.service;

import com.example.OrderService.dto.InventoryResponse;
import com.example.OrderService.dto.OrderLineDto;
import com.example.OrderService.dto.OrderRequest;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderLineItems;
import com.example.OrderService.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private WebClient webClient;
    public void saveOrder(OrderRequest orderRequest)
    {
        Order order= new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems>  orderLineItems= orderRequest.getOrderLineDtoList()
                .stream()
                .map(this::mapTo).toList();


        order.setOrderLineItems(orderLineItems);

        List<String> skuCode = order.getOrderLineItems().stream().map(orderLineItems1 -> orderLineItems1.getSkucode()).toList();

        InventoryResponse[] inventoryResponses= webClient.get().uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCode).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProduct = Arrays.stream(inventoryResponses).allMatch(inventoryResponse -> inventoryResponse.isInStock());

        if(allProduct)
            orderRepo.save(order);
        else
            throw new IllegalArgumentException("Not in Stock");
    }

    private OrderLineItems mapTo(OrderLineDto orderLineDto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setPrice(orderLineDto.getPrice());
        orderLineItems.setQuantity(orderLineDto.getQuantity());
        orderLineItems.setSkucode(orderLineDto.getSkucode());
        return orderLineItems;
    }
}
