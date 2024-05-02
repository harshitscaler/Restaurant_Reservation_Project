package com.sst.restaurant_reservation_project.GlobalException;

import com.sst.restaurant_reservation_project.Dtos.ExceptionDTO;
import com.sst.restaurant_reservation_project.Exceptions.InvalidBookingException;
import com.sst.restaurant_reservation_project.Exceptions.RestaurantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleRestaurantNotFoundException(RestaurantNotFoundException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTime(new Date());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidBookingException.class)
    public ResponseEntity<ExceptionDTO> handleInvalidBookingException(InvalidBookingException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTime(new Date());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

}
