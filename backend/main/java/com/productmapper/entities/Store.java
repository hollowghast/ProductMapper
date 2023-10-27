package com.productmapper.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
    @CsvIgnore
    private Company company;

    @OneToOne(cascade = CascadeType.ALL) //done
    @JoinColumn(name = "address_id", nullable = false)
    @CsvBindByName
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store") //done
    @JsonIgnore
    @CsvIgnore
    private List<LocalProduct> localProducts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store") //done
    @JsonIgnore
    @CsvIgnore
    private List<OpeningHours> opening_hours;


    public Store(Company company, Address address) {
        this.company = company;
        this.address = address;
    }
}
