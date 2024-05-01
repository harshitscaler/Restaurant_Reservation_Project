package com.sst.restaurant_reservation_project.CustomExceptions;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String Message){
        super(Message);
    }
}
