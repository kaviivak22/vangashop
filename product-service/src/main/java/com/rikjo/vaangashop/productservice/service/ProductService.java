package com.rikjo.vaangashop.productservice.service;

import com.rikjo.vaangashop.productservice.dto.ProductDTO;
import com.rikjo.vaangashop.productservice.entity.Product;
import com.rikjo.vaangashop.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j; 
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository repository;

    private ProductDTO toDTO(Product p) {
        return ProductDTO.builder().id(p.getId()).name(p.getName()).description(p.getDescription())
                .category(p.getCategory()).price(p.getPrice()).stock(p.getStock()).imageUrl(p.getImageUrl()).build();
    }

    private Product toEntity(ProductDTO d) {
        return Product.builder().id(d.getId()).name(d.getName()).description(d.getDescription())
                .category(d.getCategory()).price(d.getPrice()).stock(d.getStock()).imageUrl(d.getImageUrl()).build();
    }

    public ProductDTO addProduct(ProductDTO dto) {
        log.info("Adding new product: {}", dto.getName());
        return toDTO(repository.save(toEntity(dto)));
    }

    public List<ProductDTO> getAllProducts() {
        log.info("Fetching all products");
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        log.info("Fetching product ID: {}", id);
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        log.info("Updating product ID: {}", id);
        Product existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setCategory(dto.getCategory());
        existing.setPrice(dto.getPrice());
        existing.setStock(dto.getStock());
        existing.setImageUrl(dto.getImageUrl());
        return toDTO(repository.save(existing));
    }

    public void deleteProduct(Long id) {
        log.info("Deleting product ID: {}", id);
        repository.deleteById(id);
    }

    public List<ProductDTO> searchProducts(String name) {
        log.info("Searching products matches: {}", name);
        return repository.findByNameContainingIgnoreCase(name).stream().map(this::toDTO).collect(Collectors.toList());
    }
}
