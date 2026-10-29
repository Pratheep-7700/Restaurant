package com.rest.service;

import com.rest.models.OrderItem;
import com.rest.repository.OrderItemRepository;
import java.util.List;

public class OrderItemService {
    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

    public List<OrderItem> getAllOrderItems() {
        return repository.findAll();
    }
}
