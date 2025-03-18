package com.chatbot.services;

import java.time.LocalDateTime;

public class BookingExistException  extends RuntimeException{
    public BookingExistException(LocalDateTime bookingDate){
        super("Booking is already exist for date :"+bookingDate);
    }
}
