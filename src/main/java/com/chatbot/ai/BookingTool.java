package com.chatbot.ai;

import com.chatbot.model.Booking;
import com.chatbot.services.BookingService;
import dev.langchain4j.agent.tool.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BookingTool {

        @Autowired
    private  BookingService bookingService;

    @Tool
    public Booking getBookingDetails(String bookingNumber , String firstName , String lastName){

        return bookingService.getBookingDetails(bookingNumber, firstName, lastName);

    }

    @Tool
    public void cancleBooking(String bookingNumber, String fistName, String lastName){
         bookingService.cancleBooking(bookingNumber, fistName,lastName);
    }
    @Tool
    public Booking createBooking(String firstName, String lastName, String phoneNumber, LocalDateTime bookingTime) {
        return bookingService.createBooking(firstName, lastName, phoneNumber, bookingTime);
    }

}
