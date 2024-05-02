package com.sst.restaurant_reservation_project.CustomExceptions;

public class TableNOtFound extends RuntimeException{
    public TableNOtFound(Long id){
        super("Could not find table with the Id : " + id);
    }
    public TableNOtFound(String message){
        super(message);
    }
}
