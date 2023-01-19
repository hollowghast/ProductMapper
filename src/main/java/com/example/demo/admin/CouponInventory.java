package com.example.demo.admin;

import javax.persistence.*;

@Entity
@Table
public class CouponInventory extends Inventory{
    @Id
    @SequenceGenerator(
            name = "seq_CouponInventory",
            sequenceName = "seq_CouponInventory",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_CouponInventory"
    )
    @Column(name = "couponInventory_id")
    private Long id;
}
