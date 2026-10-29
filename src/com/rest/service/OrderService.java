package com.rest.service;

import com.rest.models.Order;
import com.rest.repository.OrderRepository;
import java.util.List;

public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }
}
