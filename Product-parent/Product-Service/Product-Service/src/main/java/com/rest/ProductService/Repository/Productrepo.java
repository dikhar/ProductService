package com.rest.ProductService.Repository;
import com.rest.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepo extends JpaRepository<Product,Integer> {

}
