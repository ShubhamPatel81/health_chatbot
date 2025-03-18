package com.chatbot.repository;

import com.chatbot.model.Booking;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepository extends CrudRepository<Booking, UUID> {
    Optional<Booking> findByBookingNumber(String bookingNumber);

    boolean existsByBookingDate(LocalDateTime bookingDate);

}
