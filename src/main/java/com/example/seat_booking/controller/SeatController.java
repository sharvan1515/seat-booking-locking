package com.example.seat_booking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seat_booking.entity.Seat;
import com.example.seat_booking.repository.SeatRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {
    
    private final SeatRepository seatRepository;

    @GetMapping("/{showId}")
    public List<Seat> getAvailableSeats(@PathVariable Long showId) {
        log.info("Seat Booking View");
        return seatRepository.findShowIdAndStatus(showId, "AVAILABLE");
    }
    

}
