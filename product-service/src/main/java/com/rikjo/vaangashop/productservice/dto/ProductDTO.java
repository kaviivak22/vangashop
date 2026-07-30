package com.rikjo.vaangashop.productservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    @NotBlank(message = "Product cannot be empty")
    private String name;
   @NotBlank(message = "SKU code cannot be empty")
    private String skuCode;
    @NotBlank(message = "Description cannot be empty")
    private String description;
    @Positive(message = "Price must be greater than zero")
    private Double price;
    private String imageUrl;
}