package com.example.demo.admin;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Inventory<T> {
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE
    )
    private String inventoryType;
    private List<T> products;
    private LocalDate created;
    private LocalDate last_change;

    public Inventory() {
    }

    public Inventory(String inventoryType, List<T> products, LocalDate created, LocalDate last_change) {
        this.inventoryType = inventoryType;
        this.products = products;
        this.created = created;
        this.last_change = last_change;
    }
}
