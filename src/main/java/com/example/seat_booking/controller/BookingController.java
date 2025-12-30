package com.example.seat_booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seat_booking.dto.BookingRequest;
import com.example.seat_booking.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> bookSeat(@RequestBody BookingRequest request) {
        bookingService.bookSeat(request);
        return ResponseEntity.ok("Seat booked successfully");
    }
}
