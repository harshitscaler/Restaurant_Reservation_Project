package com.sst.restaurant_reservation_project.CustomExceptions;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(String message){
        super(message);
    }
    public CustomerNotFound(Long id){
        super("Could not find customer with the Id : " + id);
    }
}
