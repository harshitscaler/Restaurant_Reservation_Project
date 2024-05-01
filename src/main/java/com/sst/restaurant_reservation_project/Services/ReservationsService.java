package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.Dtos.RequestReservationDto;
import com.sst.restaurant_reservation_project.Models.R_Table;
import com.sst.restaurant_reservation_project.Models.Reservation;
import com.sst.restaurant_reservation_project.Repositories.ReservationsRepository;
import com.sst.restaurant_reservation_project.Repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationsService {
    private ReservationsRepository reservationsRepository;
    private TableService tableService;
//    private long id=1;
    ReservationsService(ReservationsRepository reservationsRepository , TableService tableService){
        this.reservationsRepository = reservationsRepository;
        this.tableService = tableService;
    }
    public List<Reservation> getAllReservations() {
        return reservationsRepository.findAll();
    }

    public R_Table createReservation(RequestReservationDto reservation) {

//        List<R_Table> = reservationsRepository.getTables(reservation.getGuests(),reservation.getDate(),reservation.getStartTime(),reservation.getEndTime());
        R_Table table = tableService.getTableById(1L);

//        id++;
        Reservation newReservation = new Reservation();
        newReservation.setTable(table);
        newReservation.setNumberOfGuests(reservation.getGuests());
        newReservation.setReservationDate(reservation.getDate());
        newReservation.setStartTime(reservation.getStartTime());
        newReservation.setEndTime(reservation.getEndTime());

//        getEndTimetable.getReservations().add(newReservation);
        reservationsRepository.save(newReservation);
        return table;
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
