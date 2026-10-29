package com.rest.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private final int tableId;
    private final List<OrderItem> orderItems;

    public Order(int id, int tableId, List<OrderItem> orderItems) {
        this.id = id;
        this.tableId = tableId;
        this.orderItems = new ArrayList<>(orderItems);
    }

    public int getId() {
        return id;
    }

    public int getTableId() {
        return tableId;
    }

    public List<OrderItem> getOrderItems() {
        return new ArrayList<>(orderItems);
    }

    public double getTotalPrice() {
        return orderItems.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tableId=" + tableId +
                ", orderItems=" + orderItems +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
