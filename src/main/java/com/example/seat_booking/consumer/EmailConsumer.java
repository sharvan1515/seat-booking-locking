package com.example.seat_booking.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.seat_booking.dto.EmailOTPRequest;
import com.example.seat_booking.service.EmailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailConsumer {
    
    private final EmailService emailService;

    @KafkaListener(topics = "email.created", groupId = "seat-booking-group")
    public void consume(EmailOTPRequest emailOTPRequest) {
        emailService.emailSend(emailOTPRequest);
    }

}
