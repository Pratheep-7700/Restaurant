package com.rest.CLI;

import java.util.Scanner;

public class RestaurantCLI {
    private final TableCLI tableCLI;
    private final MenuItemCLI menuItemCLI;
    private final OrderItemCLI orderItemCLI;
    private final OrderCLI orderCLI;
    private final BillCLI billCLI;
    private final PaymentCLI paymentCLI;
    private final Scanner scanner = new Scanner(System.in);

    public RestaurantCLI(TableCLI tableCLI, MenuItemCLI menuItemCLI,
                         OrderItemCLI orderItemCLI, OrderCLI orderCLI,
                         BillCLI billCLI, PaymentCLI paymentCLI) {
        this.tableCLI = tableCLI;
        this.menuItemCLI = menuItemCLI;
        this.orderItemCLI = orderItemCLI;
        this.orderCLI = orderCLI;
        this.billCLI = billCLI;
        this.paymentCLI = paymentCLI;
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n*******Restaurant Management System*******");
            System.out.println("1. View Tables");
            System.out.println("2. View Menu Items");
            System.out.println("3. View Order Items");
            System.out.println("4. View Orders");
            System.out.println("5. View Bills");
            System.out.println("6. View Payments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a number from 1 to 7.");
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    tableCLI.start();
                    break;
                case 2:
                    menuItemCLI.start();
                    break;
                case 3:
                    orderItemCLI.start();
                    break;
                case 4:
                    orderCLI.start();
                    break;
                case 5:
                    billCLI.start();
                    break;
                case 6:
                    paymentCLI.start(scanner);
                    break;
                case 7:
                    System.out.println("Thank you...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }
}
