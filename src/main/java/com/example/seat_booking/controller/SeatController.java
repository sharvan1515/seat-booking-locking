package com.example.seat_booking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seat_booking.entity.Seat;
import com.example.seat_booking.repository.SeatRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {
    
    private final SeatRepository seatRepository;

    @GetMapping("/{showId}")
    public List<Seat> getAvailableSeats(@PathVariable Long showId) {
        return seatRepository.findShowIdAndStatus(showId, "AVAILABLE");
    }
    

}
