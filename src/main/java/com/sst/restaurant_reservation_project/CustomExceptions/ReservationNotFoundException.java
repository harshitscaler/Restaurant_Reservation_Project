package com.sst.restaurant_reservation_project.CustomExceptions;

public class ReservationNotFoundException extends Exception{
    public ReservationNotFoundException(Long id) {
        super("Could not find reservation with the Id : " + id);
    }
}
