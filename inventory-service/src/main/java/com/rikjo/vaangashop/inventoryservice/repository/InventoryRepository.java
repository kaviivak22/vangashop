package com.rikjo.vaangashop.inventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikjo.vaangashop.inventoryservice.entity.Inventory;



public interface InventoryRepository  extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}

