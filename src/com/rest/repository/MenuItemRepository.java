package com.rest.repository;

import com.rest.models.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository {
    private final List<MenuItem> menuItems = new ArrayList<>();

    public MenuItemRepository() {
        menuItems.add(new MenuItem(1, "Veg Burger", 200));
        menuItems.add(new MenuItem(2, "Fresh Juice", 50));
        menuItems.add(new MenuItem(3, "Pasta", 300));
    }

    public List<MenuItem> findAll() {
        return new ArrayList<>(menuItems);
    }
}
