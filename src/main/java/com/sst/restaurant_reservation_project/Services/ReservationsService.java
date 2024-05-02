package com.sst.restaurant_reservation_project.Services;

import com.sst.restaurant_reservation_project.CustomExceptions.TableNOtFound;
import com.sst.restaurant_reservation_project.Dtos.CustomerDto;
import com.sst.restaurant_reservation_project.Dtos.RequestReservationDto;
import com.sst.restaurant_reservation_project.Models.Customer;
import com.sst.restaurant_reservation_project.Models.Location;
import com.sst.restaurant_reservation_project.Models.R_Table;
import com.sst.restaurant_reservation_project.Models.Reservation;
import com.sst.restaurant_reservation_project.Repositories.ReservationsRepository;
import com.sst.restaurant_reservation_project.Repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Service
public class ReservationsService {
    private ReservationsRepository reservationsRepository;
    private TableService tableService;
    private CustomerService customerService;
//    private long id=1;
    ReservationsService(ReservationsRepository reservationsRepository , TableService tableService , CustomerService customerService){
        this.reservationsRepository = reservationsRepository;
        this.tableService = tableService;
        this.customerService = customerService;
    }
    public List<Reservation> getAllReservations() {
        return reservationsRepository.findAll();
    }

    public R_Table createReservation(RequestReservationDto reservation) throws Exception {

        if(reservation.getLocation()==null) throw new Exception("please provide valid location");

        //If customer is new It will get Created
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(reservation.getName());
        customerDto.setEmail(reservation.getEmail());
        customerDto.setContactNumber(reservation.getPhoneNumber());
        Customer customer = customerService.createCustomer(customerDto);



        Long guests = reservation.getGuests();
            LocalDate reservedDate = reservation.getDate();
            LocalTime startTime = reservation.getStartTime();
            LocalTime endTime = reservation.getEndTime();


            Location locationEnum = Location.WINDOWSIDED;
//            System.out.println(reservation.getLocation());
            if( reservation.getLocation().equals("PRIVATECABIN")) {

                locationEnum = Location.PRIVATECABIN;
            }
            if(reservation.getLocation().equals("GENERALL")) {

                System.out.println("condition check");

            }


        List<R_Table> tables = tableService.getAllTables();
        for(int i=0;i<tables.size();i++){
            System.out.println(tables.get(i).toString());
            if(tables.get(i).getCapacity()<guests) continue;
            if(tables.get(i).getLocation()!=(locationEnum)) {
                System.out.println("Location not matched = "+tables.get(i).getLocation() + " != "+locationEnum);
                continue;
            };

            System.out.println("Passed tables = "+tables.get(i).toString());


            List<Reservation> reservations = tables.get(i).getReservations();
            boolean isReserved = false;
            for(int j=0;j<reservations.size();j++){
                Reservation currentReservation = reservations.get(j);
                if(currentReservation.getReservationDate().isEqual(reservedDate)){
                    if((startTime.isAfter(currentReservation.getStartTime()) && startTime.isBefore(currentReservation.getEndTime())) || endTime.isAfter(currentReservation.getStartTime()) && endTime.isBefore(currentReservation.getEndTime())){
                        isReserved = true;
                        break;
                    }
                }
            }
            if(!isReserved){
                Reservation newReservation = new Reservation();
                newReservation.setReservationDate(reservedDate);
                newReservation.setStartTime(startTime);
                newReservation.setEndTime(endTime);
                newReservation.setTable(tables.get(i));
                newReservation.setNumberOfGuests(guests);
                newReservation.setCustomer(customer);
                newReservation.setCurrDate(LocalDate.now());
                newReservation.setCurrTime(LocalTime.now());
                reservationsRepository.save(newReservation);
                tables.get(i).getReservations().add(newReservation);
                customer.getReservationHistory().add(newReservation);
                return tables.get(i);
            }

        }
        throw new TableNOtFound("No tables available for the given reservation");
    }

    void bookTable(R_Table table, RequestReservationDto reservation){}


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
