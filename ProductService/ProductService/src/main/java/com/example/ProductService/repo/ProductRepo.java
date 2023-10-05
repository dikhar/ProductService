package com.example.ProductService.repo;

import com.example.ProductService.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}
