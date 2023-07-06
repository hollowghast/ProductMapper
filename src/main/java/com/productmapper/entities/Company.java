package com.productmapper.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column(name = "company_name", nullable = false)
    private String name;

    @Lob
    private byte [] logo;

    public Company(String name) {
        this.name = name;
    }
}
