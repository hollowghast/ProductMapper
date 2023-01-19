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
    @Column(name = "shop_id")
    private Long id;
    private String company;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String shopLeader;
    @OneToOne
    @JoinColumn(name = "mainInventory_id")
    private MainInventory mainInv;
    @OneToOne
    @JoinColumn(name = "individualInventory_id")
    private IndividualInventory individualInv;
    @OneToOne
    @JoinColumn(name = "couponInventory_id")
    private CouponInventory couponInv;


    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }

    public String getShopLeader() {
        return shopLeader;
    }

    public MainInventory getMainInv() {
        return mainInv;
    }

    public IndividualInventory getIndividualInv() {
        return individualInv;
    }

    public CouponInventory getCouponInv() {
        return couponInv;
    }
}
