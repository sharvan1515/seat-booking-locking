package com.example.seat_booking.service;

import org.springframework.stereotype.Service;

import com.example.seat_booking.dto.BookingRequest;
import com.example.seat_booking.entity.Booking;
import com.example.seat_booking.entity.Seat;
import com.example.seat_booking.exception.SeatAlreadyBookedOrNotFound;
import com.example.seat_booking.repository.BookingRepository;
import com.example.seat_booking.repository.SeatRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    // private final SeatLockService seatLockService;

    @Transactional
    public void bookSeat(BookingRequest bookingRequest) {

        Seat seat = seatRepository.findSeatForUpdate(bookingRequest.getSeatId())
                .orElseThrow(() -> new SeatAlreadyBookedOrNotFound("Seat not found"));

        if (!seat.getStatus().equals("AVAILABLE")) {
            throw new SeatAlreadyBookedOrNotFound("Seat Already booked");

        }

        // Mark Seat as booked

        seat.setStatus("BOOKED");
        seatRepository.save(seat);

        // create booking record

        Booking booking = new Booking();
        booking.setUserId(bookingRequest.getUserId());
        booking.setShowId(bookingRequest.getShowId());
        booking.setSeatId(bookingRequest.getSeatId());
        booking.setStatus("CONFIRMED");

        bookingRepository.save(booking);

    }

    // @Transactional
    // public void bookSeat(BookingRequest bookingRequest) {

    // Boolean locked = seatLockService.lockSeat(bookingRequest.getSeatId());

    // System.out.println("Shravn");
    // System.out.println(locked);

    // if (!locked) {
    // throw new RuntimeException("Seat Temporary locked");
    // }

    // try {
    // Seat seat = seatRepository.findSeatForUpdate(bookingRequest.getSeatId())
    // .orElseThrow(() -> new RuntimeException("Seat not found"));

    // if (!seat.getStatus().equals("AVAILABLE")) {
    // throw new RuntimeException("Seat Already booked");
    // }

    // // Mark Seat as booked

    // seat.setStatus("BOOKED");
    // seatRepository.save(seat);

    // // create booking record

    // Booking booking = new Booking();
    // booking.setUserId(bookingRequest.getUserId());
    // booking.setShowId(bookingRequest.getShowId());
    // booking.setSeatId(bookingRequest.getSeatId());
    // booking.setStatus("CONFIRMED");

    // bookingRepository.save(booking);
    // } finally {
    // seatLockService.unlockSeat(bookingRequest.getSeatId());
    // }

    // }
}
