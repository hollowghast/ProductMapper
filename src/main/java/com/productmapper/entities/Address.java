package com.productmapper.entities;

import javax.persistence.*;

@Entity
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
    @Column(name = "address_id")
    private Long id;
    private String country;
    private String district;
    private String zipcode;
    private String city;
    private String street;
    private String details;

    @OneToOne(mappedBy = "address") //done
    private Store store;

    public Store getShop() {
        return store;
    }

    public void setShop(Store store) {
        this.store = store;
    }

    public Address() {
    }

    public Address(Long id, String country, String district,
                   String zipcode, String city, String street, String details) {
        this.id = id;
        this.country = country;
        this.district = district;
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
        this.details = details;
    }
}
