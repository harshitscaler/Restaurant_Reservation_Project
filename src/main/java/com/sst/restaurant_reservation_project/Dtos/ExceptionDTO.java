package com.sst.restaurant_reservation_project.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionDTO {
    private String message;
    private Date time;
}
