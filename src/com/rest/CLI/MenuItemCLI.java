package com.rest.CLI;

import com.rest.models.MenuItem;
import com.rest.service.MenuItemService;

public class MenuItemCLI {
    private final MenuItemService service;

    public MenuItemCLI(MenuItemService service) {
        this.service = service;
    }

    public void start() {
        System.out.println("\n ======= MENU ITEMS =======");
        for (MenuItem menuItem : service.getAllMenuItems()) {
            System.out.println(menuItem);
        }
    }
}
