package com.rest.Orderservice.orderservice.repository;

import com.rest.Orderservice.orderservice.model.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<order,Long> {
}
