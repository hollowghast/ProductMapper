package com.productmapper.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
public class LocalProduct {
    @Id
    @SequenceGenerator(
            name = "seq_Local_Product",
            sequenceName = "seq_Local_Product",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Local_Product"
    )
    @Column(name = "local_product_id")
    private Long id;
    //private String inventoryType;
    @ManyToOne
    @JoinColumn(name = "base_product_id", nullable = false)
    private BaseProduct base_product;
    @Column(nullable = false,
    columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private final OffsetDateTime created;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime last_change;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false) //done
    @JsonIgnore
    private Store store;

    @OneToMany(mappedBy = "local_product")
    @JsonIgnore
    private List<Price> prices;

    public LocalProduct() {
        this.created = OffsetDateTime.now();
    }

    public LocalProduct(BaseProduct base_product, Store store) {
        this.base_product = base_product;
        this.store = store;
        this.created = OffsetDateTime.now();//should be done in the DB with a trigger
    }
}
