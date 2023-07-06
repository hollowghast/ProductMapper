package com.productmapper.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Brand {
    @Id
    @SequenceGenerator(
            name = "seq_Brand",
            sequenceName = "seq_Brand",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Brand"
    )
    @Column(name = "brand_id")
    private Long id;
    @Column(name = "brand_name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "brand")
    private List<Base_Product> base_products;

    public Brand(String name) {
        this.name = name;
    }
}
