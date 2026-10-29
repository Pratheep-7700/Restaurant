package com.rest.models;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private final int id;
    private final Order order;

    public Bill(int id, Order order) {
        this.id = id;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public int getOrderId() {
        return order.getId();
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(order.getOrderItems());
    }

    public double getTotalAmount() {
        return order.getTotalPrice();
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", orderId=" + getOrderId() +
                ", tableId=" + order.getTableId() +
                ", items=" + getItems() +
                ", totalAmount=" + getTotalAmount() +
                '}';
    }
}
