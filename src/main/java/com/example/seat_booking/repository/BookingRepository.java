package com.example.seat_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seat_booking.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{}

