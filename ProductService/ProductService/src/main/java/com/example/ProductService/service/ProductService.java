package com.example.ProductService.service;

import com.example.ProductService.dto.ProductRequest;
import com.example.ProductService.dto.ProductResponse;
import com.example.ProductService.entitiy.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();
}
