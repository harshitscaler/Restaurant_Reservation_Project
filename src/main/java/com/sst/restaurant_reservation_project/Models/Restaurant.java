package com.sst.restaurant_reservation_project.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @OneToMany
    private List<R_Table> Tables;

    @OneToMany
    private List<Role> roles;

    @OneToMany
    private List<Department> departments;

    @OneToMany
    private List<Employee> employees;

    @OneToMany
    private List<Customer> customers;


}
