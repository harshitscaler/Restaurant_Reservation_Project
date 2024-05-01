package com.sst.restaurant_reservation_project.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn
    private Department department;

    @ManyToOne
    @JoinColumn
    private Role role;
    public Employee() {
    }

    public Employee(String name, String email, Department department, Role role) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.role = role;
    }

    @OneToMany
    private Set<Reservation> reservations;

}
