package com.chatbot.services;

import com.chatbot.model.Booking;
import com.chatbot.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
   private  BookingRepository bookingRepository;

    public Booking saveBooking (Booking booking){
        bookingRepository.save(booking);
        return booking;
    }

    public List<Booking> showBooking(){
        return (List<Booking>) bookingRepository.findAll();
    }

}
