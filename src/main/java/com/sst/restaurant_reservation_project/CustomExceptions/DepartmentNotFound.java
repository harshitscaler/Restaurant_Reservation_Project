package com.sst.restaurant_reservation_project.CustomExceptions;

public class DepartmentNotFound extends RuntimeException{
    public DepartmentNotFound(String name){
        super("Could not find department with the Id : " + name);
    }
    public DepartmentNotFound(Long id){
        super("Could not find department with the Id : " + id);
    }
}
