package com.productmapper.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

public enum Weekday {
    MO("Monday"), TU("Tuesday"), WE("Wednesday"), TH("Thursday"),
    FR("Friday"), SA("Saturday"), SU("Sunday");
    @Column(name = "weekday_name")
    final String name;

    Weekday(String name) {
        this.name = name;
    }
}
