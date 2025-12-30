package com.example.seat_booking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    
    private Long userId;
    private Long showId;
    private Long seatId;

}
