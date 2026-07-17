package com.rikjo.vaangashop.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer stock;
    private String imageUrl;
}