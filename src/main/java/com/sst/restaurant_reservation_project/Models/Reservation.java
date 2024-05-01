package com.sst.restaurant_reservation_project.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne

    private Customer customer;

    private Long tableId;

    private Long numberOfGuests;

    private LocalDate reservationDate;

    private LocalTime reservationTime;


}