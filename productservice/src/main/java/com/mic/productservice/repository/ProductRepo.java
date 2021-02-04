package com.mic.productservice.repository;

import com.mic.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product getProductByName(String productName);
}
