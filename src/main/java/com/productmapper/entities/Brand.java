package com.productmapper.entities;

import javax.persistence.*;
import java.util.List;

@Entity
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
    @Column(name = "brand_name")
    private String name;
    @OneToMany(mappedBy = "brand")
    private List<Base_Product> base_products;
}
