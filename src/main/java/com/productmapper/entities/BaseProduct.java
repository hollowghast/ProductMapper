package com.productmapper.entities;

import com.productmapper.constants.MassUnits;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BaseProduct {
    @Id
    @SequenceGenerator(
            name = "seq_Base_Product",
            sequenceName = "seq_Base_Product",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Base_Product"
    )
    private Long id;
    private String barcode; //pk?
    private String serial_number; //pk?
    @Column(name = "base_product_name", nullable = false)
    private String name;
    private Float price_unit;
    private Double net_mass;
    private String currency; //->enum
    private MassUnits mass_unit; //->enum
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    public BaseProduct(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
    }

    public Double convertMass(){
        return this.mass_unit.convert(this.net_mass);
    }
}
