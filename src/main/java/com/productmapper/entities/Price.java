package com.productmapper.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.productmapper.constants.PriceType;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Data
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
    @JoinColumn(name = "local_product_id", nullable = false)
    @JsonIgnore
    private LocalProduct local_product;
    @Column(nullable = false)
    private Float price;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private OffsetDateTime start_date;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime end_date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PriceType type;

    public Price(LocalProduct local_product, Float price, OffsetDateTime start_date, PriceType type) {
        this.local_product = local_product;
        this.price = price;
        this.start_date = start_date;
        this.type = type;
    }
}
