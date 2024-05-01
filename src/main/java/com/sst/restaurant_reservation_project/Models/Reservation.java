package com.sst.restaurant_reservation_project.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Long numberOfGuests;

    private LocalDate reservationDate;

    private LocalTime reservationTime;



    @ManyToOne
    private R_Table table;
}