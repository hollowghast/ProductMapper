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
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToOne(cascade = CascadeType.ALL) //done
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store") //done
    private List<Local_Product> localProducts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store") //done
    private List<OpeningHours> opening_hours;


    public Store(Company company, Address address) {
        this.company = company;
        this.address = address;
    }
}
