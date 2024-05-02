package com.sst.restaurant_reservation_project.Controllers;

import com.sst.restaurant_reservation_project.CustomExceptions.ReservationNotFoundException;
import com.sst.restaurant_reservation_project.Dtos.RequestReservationDto;
import com.sst.restaurant_reservation_project.Models.R_Table;
import com.sst.restaurant_reservation_project.Models.Reservation;
import com.sst.restaurant_reservation_project.Services.ReservationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {
    ReservationsService reservationsService;
    ReservationsController(ReservationsService reservationsService) {

        this.reservationsService = reservationsService;
    }
    @GetMapping("")
    public List<Reservation> fetchAllReservations() {
        return reservationsService.getAllReservations();
    }

    @PostMapping("")
    public Long createReservation(@RequestBody RequestReservationDto reservationDto) throws Exception {
        return reservationsService.createReservation(reservationDto).getId();
    }

    @GetMapping("{reservationId}")
    public Reservation getReservationById(@PathVariable Long reservationId) throws ReservationNotFoundException {
       Optional<Reservation> reservation = Optional.ofNullable(reservationsService.getReservationById(reservationId));
       if(reservation.isPresent()){
           return reservation.get();
       }else{
           throw new ReservationNotFoundException(reservationId);
       }
    }


    @PatchMapping("{reservationId}")
    public Reservation updateReservation(@PathVariable Long reservationId, @RequestBody Reservation reservation) {
        reservation.setId(reservationId);
        return reservationsService.updateReservation(reservation);
    }

    @DeleteMapping("{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId) {
        reservationsService.deleteReservation(reservationId);
    }



}
