package com.chatbot.services;


    public class BookingNotFoundException extends RuntimeException {
        public BookingNotFoundException(String bookingNumber) {
            super("Booking not found with booking number: " + bookingNumber);
        }
    }