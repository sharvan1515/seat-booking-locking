package com.example.seat_booking.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.seat_booking.dto.EmailOTPRequest;
import com.example.seat_booking.entity.EmailOTP;
import com.example.seat_booking.repository.EmailOTPRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    private final EmailOTPRepository emailOTPRepository;

    public void emailSend(EmailOTPRequest request) {

        log.info("Started");
        
        String otp = String.format("%04d", (int) (Math.random() * 10000));

        EmailOTP emailOTP = new EmailOTP();

        emailOTP.setOtp(Long.parseLong(otp));
        emailOTP.setEmailSent("No");
        emailOTPRepository.save(emailOTP);
        
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.getEmail());
            message.setSubject("OTP");
            message.setText(otp);
            javaMailSender.send(message);
            
            emailOTP.setEmailSent("Yes");
            emailOTPRepository.save(emailOTP);
            log.info("Ho gaya");
        } catch (Exception e) {
            log.info("Kuch problem hai");
            e.printStackTrace();
        }
    }

}
