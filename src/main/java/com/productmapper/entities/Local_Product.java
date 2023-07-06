package com.productmapper.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Local_Product {
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
    @JoinColumn(name = "base_product_id")
    private Base_Product base_product;
    private final LocalDate created;
    private LocalDate last_change;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id") //done
    private Store store;

    @OneToMany(mappedBy = "local_product")
    private List<Price> prices;

    public Local_Product() {
        this.created = LocalDate.now();
    }

}
