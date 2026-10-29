package com.rest.repository;

import com.rest.models.MenuItem;
import com.rest.models.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class OrderItemRepository {
    private final List<OrderItem> orderItems = new ArrayList<>();

    public OrderItemRepository(MenuItemRepository menuItemRepository) {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        orderItems.add(new OrderItem(1, menuItems.get(0), 2));
        orderItems.add(new OrderItem(2, menuItems.get(1), 1));
    }

    public List<OrderItem> findAll() {
        return new ArrayList<>(orderItems);
    }
}
