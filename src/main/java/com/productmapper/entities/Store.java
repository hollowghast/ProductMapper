package com.productmapper.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store {
    @Id
    @SequenceGenerator(
            name = "seq_Store",
            sequenceName = "seq_Store",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Store"
    )
    @Column(name = "store_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL) //done
    @JoinColumn(name = "address_id")
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store") //done
    private List<Local_Product> localProducts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store") //done
    private List<OpeningHours> opening_hours;

    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }


}
