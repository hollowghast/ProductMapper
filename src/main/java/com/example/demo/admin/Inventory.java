package com.example.demo.admin;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
public abstract class Inventory {

    //private String inventoryType;
    @OneToMany(targetEntity = BasicProduct.class)
    private List<BasicProduct> products;
    private LocalDate created;
    private LocalDate last_change;

    @OneToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Inventory() {
    }

    public Inventory(List<BasicProduct> products, LocalDate created, LocalDate last_change) {
        this.products = products;
        this.created = created;
        this.last_change = last_change;
    }
}
