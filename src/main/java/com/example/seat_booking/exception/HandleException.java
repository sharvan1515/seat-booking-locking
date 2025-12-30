package com.example.seat_booking.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception ex) {
        return new ErrorResponse(ex.getMessage(), 500);
    }


    @ExceptionHandler(SeatAlreadyBookedOrNotFound.class)
    public ErrorResponse SeatAlreadyBooked(SeatAlreadyBookedOrNotFound ex) {
        return new ErrorResponse(ex.getMessage(), 500);
    }

}
