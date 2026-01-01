package com.example.seat_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seat_booking.entity.EmailOTP;

@Repository
public interface EmailOTPRepository extends JpaRepository<EmailOTP, Long> {
    
}
