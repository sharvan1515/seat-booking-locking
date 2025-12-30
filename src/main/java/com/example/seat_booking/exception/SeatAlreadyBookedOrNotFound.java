package com.example.seat_booking.exception;

public class SeatAlreadyBookedOrNotFound extends RuntimeException {
    public SeatAlreadyBookedOrNotFound(String message){
        super(message);
    }
}
