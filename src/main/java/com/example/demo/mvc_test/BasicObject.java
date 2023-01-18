package com.example.demo.mvc_test;

import javax.persistence.*;

@Entity
@Table
public class BasicObject {
    private String name;
    @Id
    @SequenceGenerator(
            name = "seq_Basic",
            sequenceName = "seq_Basic",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "seq_Basic",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    public BasicObject() {
    }

    public BasicObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
