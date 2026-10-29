package com.rest.repository;

import com.rest.models.Bill;
import com.rest.models.Order;
import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    private final List<Bill> bills = new ArrayList<>();

    public BillRepository(OrderRepository orderRepository) {
        int billId = 1;
        for (Order order : orderRepository.findAll()) {
            bills.add(new Bill(billId++, order));
        }
    }

    public List<Bill> findAll() {
        return new ArrayList<>(bills);
    }
}
