package com.rest.service;

import com.rest.models.Payment;
import com.rest.payment.PaymentMethod;
import com.rest.repository.PaymentRepository;
import java.util.List;

public class PaymentService {
    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment processPayment(PaymentMethod method, double amount) {
        method.pay(amount);
        Payment payment = new Payment(
                repository.nextId(),
                amount,
                method.getMethodName(),
                "SUCCESS"
        );
        repository.save(payment);
        return payment;
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }
    public Payment getPaymentById(int id) {
        return repository.findById(id);
    }

    public Payment cancelPayment(int id) {
        Payment payment = repository.findById(id);
        if (payment != null) {
            payment.cancel();
        }
        return payment;
    }
}
