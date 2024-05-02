package com.sst.restaurant_reservation_project.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class RequestReservationDto {
    private String name;
    private String email;
    private String phoneNumber;

    private Long guests;
    private String location;

    @Override
    public String toString() {
        return "RequestReservationDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", guests=" + guests +
                ", Location='" + location + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

}
