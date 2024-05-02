package com.sst.restaurant_reservation_project.CustomExceptions;

public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(Long id){
        super("Employee not found with id: " + id);
    }
}
