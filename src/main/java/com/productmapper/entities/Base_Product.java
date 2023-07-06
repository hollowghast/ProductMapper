package com.productmapper.entities;

import javax.persistence.*;

@Entity
public class Base_Product {
    @Id
    @SequenceGenerator(
            name = "seq_Base_Product",
            sequenceName = "seq_Base_Product",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Base_Product"
    )
    private Long id;
    private String barcode; //pk?
    private String serial_number; //pk?
    private String name;
    private Float price_unit;
    private Integer net_mass;
    private String currency; //->enum
    private String mass_unit; //->enum
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
