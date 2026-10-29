package com.rest.models;

public class OrderItem {
    private final int id;
    private final MenuItem menuItem;
    private final int quantity;

    public OrderItem(int id, MenuItem menuItem, int quantity) {
        this.id = id;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", " +
                "menuItem=" + menuItem +
                ", quantity=" + quantity +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
