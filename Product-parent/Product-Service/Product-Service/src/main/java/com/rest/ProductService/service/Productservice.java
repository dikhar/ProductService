package com.rest.ProductService.service;

import com.rest.ProductService.Repository.Productrepo;
import com.rest.ProductService.dto.ProductRequest;
import com.rest.ProductService.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.rest.ProductService.model.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class Productservice {
    private final Productrepo productrepo;

    public void createProduct(ProductRequest productRequest)
    {
        ProductRequest productRequest1=new ProductRequest();
        Product product=Product.builder()
                .name(productRequest1.getName())
                .desc(productRequest1.getDesc()).price(productRequest1.getPrice()).build();
        productrepo.save(product);
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products=productrepo.findAll();
        return products.stream().map(this::mapToProductResponse).toList();

    }
    private ProductResponse mapToProductResponse(Product productResponseobj) {
        return ProductResponse.builder().
                id(productResponseobj.getId())
                .name(productResponseobj.getName())
                        .desc(productResponseobj.getDesc())
                            .price(productResponseobj.getPrice()).build();
    }
}
