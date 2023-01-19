package com.example.demo.admin;

import javax.persistence.*;

@Entity
@Table
public class IndividualInventory extends Inventory {
    @Id
    @SequenceGenerator(
            name = "seq_IndividualInventory",
            sequenceName = "seq_IndividualInventory",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_IndividualInventory"
    )
    @Column(name = "individualInventory_id")
    private Long id;
}
