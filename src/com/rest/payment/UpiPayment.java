package com.rest.payment;

public class UpiPayment implements PaymentMethod {
    @Override
    public String getMethodName() {
        return "UPI";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Simulated UPI payment processed: " + amount);
    }
}
