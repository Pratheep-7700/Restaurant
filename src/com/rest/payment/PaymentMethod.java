package com.rest.payment;

public interface PaymentMethod {
    String getMethodName();

    void pay(double amount);
}
