package com.productmapper.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class OpeningHours {
    @Id
    @SequenceGenerator(
            name = "seq_Opening_Hours",
            sequenceName = "seq_Opening_Hours",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_Opening_Hours"
    )
    @Column(name = "opening_hours_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private Weekday weekday;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id") //done
    private Store store;
    private LocalDateTime start_time, end_time;
    private LocalDate date;
}
