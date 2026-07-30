package com.rikjo.vaangashop.inventoryservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rikjo.vaangashop.inventoryservice.dto.InventoryResponse;
import com.rikjo.vaangashop.inventoryservice.service.InventoryService;



@RestController
@RequestMapping("inventory")
@Slf4j
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
   
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        log.info("Received inventory check request for skuCode: {}", skuCode);
        return inventoryService.isInStock(skuCode);
    }
      
}
