package com.productmapper.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @SequenceGenerator(name="seq_Company",
            sequenceName = "seq_Company")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "seq_Company")
    @Column(name = "company_id")
    private Long id;

    @OneToMany(mappedBy = "company",
    cascade = CascadeType.ALL) //done
    private List<Store> stores;
}
