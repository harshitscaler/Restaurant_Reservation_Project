package com.sst.restaurant_reservation_project.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Department {

<<<<<<< HEAD
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @OneToMany
        private List<Employee> employees;

        public Department() {
        }

        public Department(String name) {
            this.name = name;
        }
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Employee> employees;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }
>>>>>>> 1e86226 (Added CustomerController and Service)
}