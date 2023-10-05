package com.example.ProductService.contoller;

import com.example.ProductService.dto.ProductRequest;
import com.example.ProductService.dto.ProductResponse;
import com.example.ProductService.entitiy.Product;
import com.example.ProductService.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandlerDecoratorFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest)
    {
        Product product=productService.saveProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponse>> getAll()
    {
        List<ProductResponse> product=productService.getAllProduct();
        return ResponseEntity.ok(product);
    }
}
