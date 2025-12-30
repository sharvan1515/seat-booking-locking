package com.example.seat_booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.seat_booking.entity.Seat;

import jakarta.persistence.LockModeType;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>{
    
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s from Seat s WHERE s.id = :seatId")
    Optional<Seat> findSeatForUpdate(Long seatId);

    @Query("SELECT s from Seat s WHERE s.showId = :showId AND s.status = :status")
    List<Seat> findShowIdAndStatus(Long showId, String status);

}