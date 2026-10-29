package com.rest.payment;

public class CardPayment implements PaymentMethod {
    @Override
    public String getMethodName() {
        return "CARD";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Simulated card payment processed: " + amount);
    }
}
