package com.rest.repository;

import com.rest.models.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public OrderRepository(OrderItemRepository orderItemRepository) {
        orders.add(new Order(1, 1, orderItemRepository.findAll()));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }
}
