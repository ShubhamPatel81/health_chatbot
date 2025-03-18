package com.chatbot.services;


import com.chatbot.model.Booking;
import com.chatbot.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    @Autowired
    private  BookingRepository bookingRepository;

    public Booking getBookingDetails(String bookingNumber, String firstName, String lastName){
        ensureExists(bookingNumber, firstName,  lastName);
        return bookingRepository.findByBookingNumber(bookingNumber)
                .orElseThrow(()->new BookingNotFoundException(bookingNumber));
    }


    public void  cancleBooking(String bookingNumber, String firstName, String lastName){
        ensureExists(bookingNumber, firstName,lastName);
    }

    public Booking createBooking(String firstName, String lastName, String phoneNumber, LocalDateTime bookingDate){
        boolean isExist = bookingRepository.existsByBookingDate(bookingDate);
        if (isExist){
            throw new BookingExistException(bookingDate);
        }
        Booking booking = new Booking();
        booking.setFirstName(firstName);
        booking.setLastName(lastName);
        booking.setBookingDate(bookingDate);
        booking.setPhoneNumber(phoneNumber);

        return bookingRepository.save(booking);

    }




    // checking weather booking exist or not
    private void  ensureExists(String bookingNumber, String firstName, String lastName){
        Booking booking = bookingRepository.findByBookingNumber(bookingNumber)
                .orElseThrow(()->new BookingNotFoundException(bookingNumber));
        if (booking == null){
            throw  new BookingNotFoundException(bookingNumber);
        }
        if (!booking.getFirstName().equals(firstName)){
            throw new BookingNotFoundException(bookingNumber);
        }
        if (!booking.getLastName().equals(lastName)){
            throw new BookingNotFoundException(bookingNumber);
        }

    }


}
