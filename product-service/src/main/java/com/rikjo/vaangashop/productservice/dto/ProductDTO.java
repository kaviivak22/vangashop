package com.rikjo.vaangashop.productservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    @NotBlank(message = "Product name cannot be empty")
    private String name;
    @NotBlank(message = "Description cannot be empty")
    private String description;
    @NotBlank(message = "Category cannot be empty")
    private String category;
    @Positive(message = "Price must be greater than zero")
    private Double price;
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;
    private String imageUrl;
}