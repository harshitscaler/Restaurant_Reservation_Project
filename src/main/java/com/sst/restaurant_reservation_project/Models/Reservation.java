package com.sst.restaurant_reservation_project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Customer customer;

    private Long numberOfGuests;

    private LocalDate reservationDate;

    private LocalDate currDate;
    private LocalTime currTime;

    private LocalTime startTime;

    private LocalTime endTime;


    @ManyToOne
    @JsonIgnore
    private R_Table table;
}