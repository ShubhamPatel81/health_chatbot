package com.chatbot.controller;


import com.chatbot.model.Booking;
import com.chatbot.repository.BookingRepository;
import com.chatbot.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book")
    public String index(Model model) {
        model.addAttribute("booking", new Booking()); // Ensure this matches 'booking'
        return "booking"; // This must match your booking.html file
    }

//    @GetMapping("/")
//    public String showHomePage(Model model) {
//        model.addAttribute("booking", new Booking()); // ✅ add empty object for form binding
//        return "index"; // or whatever your template is called
//    }


    @PostMapping("/book")
    public String book(@ModelAttribute Booking booking, Model model) {

//        String id = UUID.randomUUID().toString();

        Booking booking1 = new Booking();
//        booking1.setId(Long.valueOf(id));
        booking1.setPhoneNumber(booking.getPhoneNumber());
        booking1.setName(booking.getName());
        booking1.setAge(booking.getAge());
        booking1.setEmail(booking.getEmail());
        booking1.setDoctor(booking.getDoctor());

        bookingService.saveBooking(booking1);

        model.addAttribute("booking ", new Booking());
        model.addAttribute("message", "Booked successfully");
        return "redirect:http://localhost:9090/";

    }

    @GetMapping("/bookings")
    public String showBookings(Model model) {
        List<Booking> bookings = bookingService.showBooking();
        model.addAttribute("bookings", bookings);
        return "showBooking";
    }


}
