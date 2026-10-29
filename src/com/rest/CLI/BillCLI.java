package com.rest.CLI;

import com.rest.models.Bill;
import com.rest.service.BillService;

public class BillCLI {
    private final BillService service;

    public BillCLI(BillService service) {
        this.service = service;
    }

    public void start() {
        System.out.println("\n ======= BILLS =======");
        for (Bill bill : service.getAllBills()) {
            System.out.println(bill);
        }
    }
}
