package com.example.seat_booking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seat_booking.dto.EmailOTPRequest;
import com.example.seat_booking.producer.EmailProducer;
// import com.example.seat_booking.service.EmailService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class LoginWithOTPController {

    // private final EmailService emailService;

    private final EmailProducer emailProducer;
    
    @PostMapping("/email/send")
    public ResponseEntity<String> emailOtpSend(@RequestBody EmailOTPRequest request) {

        emailProducer.publishEmailEvent(request);

        //emailService.emailSend(request);
        return ResponseEntity.ok("OTP sent to emailId");
    }
}
