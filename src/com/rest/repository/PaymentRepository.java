package com.rest.repository;

import com.rest.models.Payment;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    private final List<Payment> payments = new ArrayList<>();

    public int nextId() {
        return payments.size() + 1;
    }

    public void save(Payment payment) {
        payments.add(payment);
    }
    public List<Payment> findAll() {
        return new ArrayList<>(payments);
    }

    public Payment findById(int id) {
        for (Payment payment : payments) {
            if (payment.getId() == id) {
                return payment;
            }
        }
        return null;
    }
 
}
