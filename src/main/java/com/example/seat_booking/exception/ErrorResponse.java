package com.example.seat_booking.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    
    private String message;
    private Integer statusCode;
    private LocalDateTime localDateTime;


    ErrorResponse(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.localDateTime = LocalDateTime.now();
    }
}
