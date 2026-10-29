package com.rest.CLI;

import com.rest.models.OrderItem;
import com.rest.service.OrderItemService;

public class OrderItemCLI {
    private final OrderItemService service;

    public OrderItemCLI(OrderItemService service) {
        this.service = service;
    }

    public void start() {
        System.out.println("\n ======= ORDER ITEMS =======");
        for (OrderItem orderItem : service.getAllOrderItems()) {
            System.out.println(orderItem);
        }
    }
}
