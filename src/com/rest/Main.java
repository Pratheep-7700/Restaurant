package com.rest;

import com.rest.CLI.BillCLI;
import com.rest.CLI.MenuItemCLI;
import com.rest.CLI.OrderCLI;
import com.rest.CLI.OrderItemCLI;
import com.rest.CLI.PaymentCLI;
import com.rest.CLI.RestaurantCLI;
import com.rest.CLI.TableCLI;
import com.rest.repository.BillRepository;
import com.rest.repository.MenuItemRepository;
import com.rest.repository.OrderItemRepository;
import com.rest.repository.OrderRepository;
import com.rest.repository.PaymentRepository;
import com.rest.service.BillService;
import com.rest.service.MenuItemService;
import com.rest.service.OrderItemService;
import com.rest.service.OrderService;
import com.rest.service.PaymentService;
import com.rest.service.TableService;

public class Main {
    public static void main(String[] args) {
        MenuItemRepository menuItemRepository = new MenuItemRepository();
        OrderItemRepository orderItemRepository = new OrderItemRepository(menuItemRepository);
        OrderRepository orderRepository = new OrderRepository(orderItemRepository);
        BillRepository billRepository = new BillRepository(orderRepository);
        PaymentRepository paymentRepository = new PaymentRepository();

        TableService tableService = new TableService();
        MenuItemService menuItemService = new MenuItemService(menuItemRepository);
        OrderItemService orderItemService = new OrderItemService(orderItemRepository);
        OrderService orderService = new OrderService(orderRepository);
        BillService billService = new BillService(billRepository);
        PaymentService paymentService = new PaymentService(paymentRepository);

        TableCLI tableCLI = new TableCLI(tableService);
        MenuItemCLI menuItemCLI = new MenuItemCLI(menuItemService);
        OrderItemCLI orderItemCLI = new OrderItemCLI(orderItemService);
        OrderCLI orderCLI = new OrderCLI(orderService);
        BillCLI billCLI = new BillCLI(billService);
        PaymentCLI paymentCLI = new PaymentCLI(paymentService);

        new RestaurantCLI(
                tableCLI,
                menuItemCLI,
                orderItemCLI,
                orderCLI,
                billCLI,
                paymentCLI
        ).start();
    }
}