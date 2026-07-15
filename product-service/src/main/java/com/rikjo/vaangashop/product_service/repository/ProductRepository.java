package com.rikjo.vaangashop.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikjo.vaangashop.product_service.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
