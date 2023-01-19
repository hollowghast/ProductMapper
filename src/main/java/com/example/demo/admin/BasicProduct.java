package com.example.demo.admin;

import javax.persistence.*;

@Entity
@Table
public class BasicProduct {
    @Id
    @SequenceGenerator(
            name = "seq_Product",
            sequenceName = "seq_Product",
            allocationSize = 1
    )
    private Long id;
    private String company;
    private String barcode;
    private String serial_number;
    private String name;
    private Float price_unit;
    private Integer net_mass;
    private String currency; //->enum
    private String mass_unit; //->enum


}
