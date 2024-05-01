package com.sst.restaurant_reservation_project.Dtos;

import com.sst.restaurant_reservation_project.Models.Location;
import com.sst.restaurant_reservation_project.Models.Reservation;
import com.sst.restaurant_reservation_project.Models.State;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class R_Table_dto {
    private int capacity;

    private String location;
}
