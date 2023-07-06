package com.productmapper.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Price {
    @Id
    @SequenceGenerator(
            name = "seq_Price",
            sequenceName = "seq_Price",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Price"
    )
    @Column(name = "price_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "local_product_id")
    private Local_Product local_product;
    private Float price;
    private LocalDate start_date, end_date;
    @Enumerated(EnumType.STRING)
    private Price_Type type;
}
