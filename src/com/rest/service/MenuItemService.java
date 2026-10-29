package com.rest.service;

import com.rest.models.MenuItem;
import com.rest.repository.MenuItemRepository;
import java.util.List;

public class MenuItemService {
    private final MenuItemRepository repository;

    public MenuItemService(MenuItemRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> getAllMenuItems() {
        return repository.findAll();
    }
}
