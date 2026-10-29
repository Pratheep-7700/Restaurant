package com.rest.service;

import com.rest.models.Bill;
import com.rest.repository.BillRepository;
import java.util.List;

public class BillService {
    private final BillRepository repository;

    public BillService(BillRepository repository) {
        this.repository = repository;
    }

    public List<Bill> getAllBills() {
        return repository.findAll();
    }
}
