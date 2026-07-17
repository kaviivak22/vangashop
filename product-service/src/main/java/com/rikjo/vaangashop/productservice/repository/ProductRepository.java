package com.rikjo.vaangashop.productservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rikjo.vaangashop.productservice.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
