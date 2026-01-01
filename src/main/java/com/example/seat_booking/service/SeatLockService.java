package com.example.seat_booking.service;

import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatLockService {
    
    private final StringRedisTemplate redisTemplate;

    private static final long LOCK_TIME = 300;

    public boolean lockSeat(Long seatId) {

        String key = "Seat:lock:" + seatId;
        
        Boolean success = redisTemplate.opsForValue().setIfAbsent(key, "LOCKED", Duration.ofSeconds(LOCK_TIME));

        return Boolean.TRUE.equals(success);
    }

    public void unlockSeat(Long seatId) {
        String key = "Seat:lock:" + seatId;
        redisTemplate.delete(key);
    }

}
