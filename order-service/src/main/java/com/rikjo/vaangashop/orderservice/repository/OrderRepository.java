package com.rikjo.vaangashop.orderservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rikjo.vaangashop.orderservice.entity.Order;


public interface OrderRepository  extends JpaRepository<Order, Long> {
}