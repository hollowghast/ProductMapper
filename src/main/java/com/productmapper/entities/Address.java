package com.productmapper.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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
    @Column(nullable = false)
    private String zipcode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    private String details;

    @OneToOne(mappedBy = "address") //done
    @JsonIgnore
    private Store store;

    public Address(String zipcode, String city, String street) {
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
    }
}
