package com.example.demo.admin;

import javax.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @SequenceGenerator(
            name = "seq_Address",
            sequenceName = "seq_Address",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Address"
    )
    private Long id;
    private String country;
    private String district;
    private String zip_code;
    private String city;
    private String street;
    private String address_details;

    public Address() {
    }

    public Address(Long id, String country, String district,
                   String zip_code, String city, String street, String address_details) {
        this.id = id;
        this.country = country;
        this.district = district;
        this.zip_code = zip_code;
        this.city = city;
        this.street = street;
        this.address_details = address_details;
    }
}
