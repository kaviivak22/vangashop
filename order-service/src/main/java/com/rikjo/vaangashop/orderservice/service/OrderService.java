package com.rikjo.vaangashop.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rikjo.vaangashop.orderservice.dto.InventoryResponse;
import com.rikjo.vaangashop.orderservice.dto.OrderLineItemsDto;
import com.rikjo.vaangashop.orderservice.dto.OrderRequest;
import com.rikjo.vaangashop.orderservice.entity.Order;
import com.rikjo.vaangashop.orderservice.entity.OrderLineItems;
import com.rikjo.vaangashop.orderservice.feignservice.InventoryFeignService;
import com.rikjo.vaangashop.orderservice.repository.OrderRepository;

import jakarta.transaction.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {
    
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private InventoryFeignService inventoryService;


    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
    
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();       
       
        List<InventoryResponse> inventoryResponseList = inventoryService.isInStock(skuCodes);

        boolean allProductsInStock = inventoryResponseList.stream()
        .allMatch(InventoryResponse::isInStock);


        if (allProductsInStock) {
            orderRepository.save(order);
            // publish Order Placed Event
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

    }

    /**
     * 
     * @param orderLineItemsDto
     * @return
     */
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

}
