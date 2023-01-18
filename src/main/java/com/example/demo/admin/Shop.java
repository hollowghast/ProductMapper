package com.example.demo.admin;

import javax.persistence.*;

@Entity
@Table
public class Shop {
    @Id
    @SequenceGenerator(
            name = "seq_Shop",
            sequenceName = "seq_Shop",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Shop"
    )
    private Long id;
    private String company;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String shopLeader;
    private Inventory<BasicProduct> mainInv, tempInv, couponInv;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
