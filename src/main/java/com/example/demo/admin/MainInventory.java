package com.example.demo.admin;

import javax.persistence.*;

@Entity
@Table
public class MainInventory extends Inventory{
    @Id
    @SequenceGenerator(
            name = "seq_MainInventory",
            sequenceName = "seq_MainInventory",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_MainInventory"
    )
    @Column(name = "mainInventory_id")
    private Long id;
}
