package com.rest.ProductService.controller;

import com.rest.ProductService.dto.ProductRequest;
import com.rest.ProductService.dto.ProductResponse;
import com.rest.ProductService.service.Productservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class productcontroller {

    private final Productservice productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productrequest)
    {
        productService.createProduct(productrequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts()
    {

        return  productService.getAllProducts();
    }
}
