package com.rikjo.vaangashop.orderservice.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rikjo.vaangashop.orderservice.dto.InventoryResponse;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryFeignService {

    @GetMapping("/inventory/{sku-codes}")
    List<InventoryResponse> getInventory(@PathVariable List<String> skuCodes);
}