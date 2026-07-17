package com.rikjo.vaangashop.productservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rikjo.vaangashop.productservice.dto.ProductDTO;
import com.rikjo.vaangashop.productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO dto) {
        return new ResponseEntity<>(service.addProduct(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(service.updateProduct(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam String name) {
        return ResponseEntity.ok(service.searchProducts(name));
    }
}
