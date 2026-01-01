package com.example.seat_booking.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.seat_booking.dto.EmailOTPRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailProducer {
    
    private static final String TOPIC = "email.created";

    private final KafkaTemplate<String, EmailOTPRequest> kafkaTemplate;

    public void publishEmailEvent(EmailOTPRequest emailCreatedEvent) {
        kafkaTemplate.send(TOPIC, emailCreatedEvent.getEmail(), emailCreatedEvent);
    }
}
