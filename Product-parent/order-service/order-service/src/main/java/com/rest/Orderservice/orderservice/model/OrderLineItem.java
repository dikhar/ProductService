package com.rest.Orderservice.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name="order_item_table")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderLineItem {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "skuCode")
    private String skuCode;

    @Column(name = "price")
    private BigInteger price;

    @Column(name = "quantity")
    private Integer quantity;
}
