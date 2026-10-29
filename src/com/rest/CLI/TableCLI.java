package com.rest.CLI;

import com.rest.models.Table;
import com.rest.service.TableService;
import java.util.List;

public class TableCLI {
    private final TableService service;

    public TableCLI(TableService service) {
        this.service = service;
    }

    public void start() {
        List<Table> tables = service.getAllTables();
        System.out.println("\n ======= ALL TABLES =======");
        for (Table table : tables) {
            System.out.println(table);
        }
    }
}