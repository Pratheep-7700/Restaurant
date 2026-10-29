package com.rest.CLI;

import com.rest.models.Order;
import com.rest.service.OrderService;

public class OrderCLI {
    private final OrderService service;

    public OrderCLI(OrderService service) {
        this.service = service;
    }

    public void start() {
        System.out.println("\n ======= ORDERS =======");
        for (Order order : service.getAllOrders()) {
            System.out.println(order);
        }
    }
}
