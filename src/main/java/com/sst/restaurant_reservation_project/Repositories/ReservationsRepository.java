package com.sst.restaurant_reservation_project.Repositories;

import com.sst.restaurant_reservation_project.Models.Location;
import com.sst.restaurant_reservation_project.Models.R_Table;
import com.sst.restaurant_reservation_project.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public interface ReservationsRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationByTableId(Long id);
//    @Query("SELECT r FROM Reservation r JOIN R_Table rt ON r.table.id = rt.id WHERE rt.capacity >= :guests AND r.table.location = :location AND ")
//    public List<R_Table> getTables(@Param("guests") int guests, @Param("date") LocalDate date, @Param("startTime") LocalTime startTime,@Param("endTime") LocalTime endTime,@Param ("location") Location location);
    
//    public List<Reservation> findReservationBy(Long tableId);
}
