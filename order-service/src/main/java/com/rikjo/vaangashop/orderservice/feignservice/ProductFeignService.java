package com.rikjo.vaangashop.orderservice.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rikjo.vaangashop.orderservice.dto.ProductDTO;


@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductFeignService {
    @GetMapping("/products/{sku-code}")
    ProductDTO getProduct(@PathVariable String skuCode);  
} 
