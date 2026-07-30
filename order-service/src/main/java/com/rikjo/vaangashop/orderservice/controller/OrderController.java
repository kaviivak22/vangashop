package com.rikjo.vaangashop.orderservice.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rikjo.vaangashop.orderservice.dto.OrderRequest;
import com.rikjo.vaangashop.orderservice.entity.Order;
import com.rikjo.vaangashop.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    
    @Autowired
    private  OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
  
    @GetMapping
    public ResponseEntity<List<Order>> getOrderHistory() {
        return ResponseEntity.ok(orderService.getOrderHistory());
    }
      
}
