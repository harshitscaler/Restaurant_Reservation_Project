package com.sst.restaurant_reservation_project.Repositories;

import com.sst.restaurant_reservation_project.Models.R_Table;
import com.sst.restaurant_reservation_project.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationsRepository extends JpaRepository<Reservation, Long> {
//    @Query("")
//    publiclic List<R_Table> getTables(int guests, LocalDate date, LocalTime startTime, LocalTime endTime);
}
