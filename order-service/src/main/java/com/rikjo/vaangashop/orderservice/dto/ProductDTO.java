package com.rikjo.vaangashop.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private String skuCode;
    private String name;
    private String description;
    private Double price;
   
}
