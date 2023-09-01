package com.productmapper.entities;

import com.productmapper.constants.Weekday;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetTime;

@Entity
@Data
@NoArgsConstructor
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
    @Enumerated(EnumType.ORDINAL)
    private Weekday weekday;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false) //done
    private Store store;
    @Column(nullable = false)
    private OffsetTime start_time;
    @Column(nullable = false)
    private OffsetTime end_time;
    private LocalDate date;

    /**
     * Sets general opening hours which are valid for EVERY day
     *
     * @param store
     * @param start_time
     * @param end_time
     */
    public OpeningHours(Store store, OffsetTime start_time, OffsetTime end_time) {
        this.store = store;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    /**
     * Sets opening hours for specific weekdays
     *
     * @param weekday
     * @param store
     * @param start_time
     * @param end_time
     */
    public OpeningHours(Weekday weekday, Store store, OffsetTime start_time, OffsetTime end_time) {
        this.weekday = weekday;
        this.store = store;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    /**
     * Sets opening hours on this specific date
     *
     * @param store
     * @param start_time
     * @param end_time
     * @param date
     */
    public OpeningHours(Store store, OffsetTime start_time, OffsetTime end_time, LocalDate date) {
        this.store = store;
        this.start_time = start_time;
        this.end_time = end_time;
        this.date = date;
    }
}
