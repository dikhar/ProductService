package com.example.ProductService.service;

import com.example.ProductService.dto.ProductRequest;
import com.example.ProductService.dto.ProductResponse;
import com.example.ProductService.entitiy.Product;
import com.example.ProductService.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(ProductRequest productRequest) {
        String random= UUID.randomUUID().toString();
        Product product= Product.builder().
                id(random).
                name(productRequest.getName()).
                price(productRequest.getPrice()).
                description(productRequest.getDescription()).build();

        return productRepo.save(product);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> products=productRepo.findAll();
        return products.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
