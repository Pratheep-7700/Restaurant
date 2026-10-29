package com.rest.CLI;

import com.rest.models.Payment;
import com.rest.payment.CardPayment;
import com.rest.payment.CashPayment;
import com.rest.payment.PaymentMethod;
import com.rest.payment.UpiPayment;
import com.rest.service.PaymentService;
import java.util.List;
import java.util.Scanner;

public class PaymentCLI {
    private final PaymentService service;

    public PaymentCLI(PaymentService service) {
        this.service = service;
    }

    public void start(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n======= PAYMENTS =======");
            System.out.println("1. Make payment");
            System.out.println("2. View payments");
            System.out.println("3. Cancel payment");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    makePayment(scanner);
                    break;
                case 2:
                    viewPayments();
                    break;
                case 3:
                    cancelPayment(scanner);
                    break;
                case 4:
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);
    }

    private void makePayment(Scanner scanner) {
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Payment amount must be greater than zero.");
            return;
        }

        System.out.println("1. Card");
        System.out.println("2. Cash");
        System.out.println("3. UPI");
        System.out.print("Choose payment method: ");
        int methodChoice = scanner.nextInt();

        PaymentMethod method;
        switch (methodChoice) {
            case 1:
                method = new CardPayment();
                break;
            case 2:
                method = new CashPayment();
                break;
            case 3:
                method = new UpiPayment();
                break;
            default:
                System.out.println("Invalid payment method.");
                return;
        }

        Payment payment = service.processPayment(method, amount);
        System.out.println("Payment completed successfully:");
        System.out.println(payment);
    }

    private void viewPayments() {
        List<Payment> payments = service.getAllPayments();
        if (payments.isEmpty()) {
            System.out.println("No payments have been recorded.");
            return;
        }

        System.out.println("\nRecorded payments:");
        for (Payment payment : payments) {
            System.out.println(payment);
        }
    }

    private void cancelPayment(Scanner scanner) {
        List<Payment> payments = service.getAllPayments();
        if (payments.isEmpty()) {
            System.out.println("There are no payments to cancel.");
            return;
        }

        viewPayments();
        System.out.print("Enter payment ID to cancel (0 to go back): ");
        int paymentId = scanner.nextInt();
        if (paymentId == 0) {
            return;
        }
        if (paymentId < 0) {
            System.out.println("Invalid payment ID.");
            return;
        }

        Payment payment = service.cancelPayment(paymentId);
        if (payment == null) {
            System.out.println("Payment not found.");
            return;
        }
        System.out.println("Payment cancelled successfully:");
        System.out.println(payment);
    }
}
