package com.rest.payment;

public class CashPayment implements PaymentMethod {
    @Override
    public String getMethodName() {
        return "CASH";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Cash payment recorded: " + amount);
    }
}
