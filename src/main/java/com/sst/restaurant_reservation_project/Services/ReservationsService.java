package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Models.Reservation;
import com.sst.restaurant_reservation_project.Repositories.ReservationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {
    private ReservationsRepository reservationsRepository;
    ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }
    public List<Reservation> getAllReservations() {
        return reservationsRepository.findAll();
    }

    public Reservation createReservation(Reservation reservation) {
        return null;
    }

    public Reservation getReservationById(Long reservationId) {
        return reservationsRepository.findById(reservationId).orElse(null);
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationsRepository.save(reservation);
    }

    public void deleteReservation(Long reservationId) {
        reservationsRepository.deleteById(reservationId);
    }

}
