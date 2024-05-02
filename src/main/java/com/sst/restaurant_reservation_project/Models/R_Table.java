package com.sst.restaurant_reservation_project.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class R_Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int capacity;

    private Location location;

    private State state;

    @OneToMany(mappedBy = "table")
    private List<Reservation> reservations;

    @Override
    public String toString() {
        return "R_Table{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", location=" + location +
                ", state=" + state +
                ", reservations=" + reservations +
                '}';
    }
}
