package com.sst.restaurant_reservation_project.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDto {


    private String name;
    private String city;

    public boolean isValid() {
        return name != null && city != null;
    }
}
