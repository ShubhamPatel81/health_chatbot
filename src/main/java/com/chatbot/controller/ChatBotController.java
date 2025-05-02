package com.chatbot.controller;

import com.chatbot.ai.ChatBotBookingSystem;
import com.chatbot.dto.ChatBotRequest;
import com.chatbot.dto.ChatBotResponse;
import com.chatbot.model.Booking;
import com.chatbot.repository.MessageRepository;
import com.chatbot.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private MessageRepository messageRepo;


    private final ChatBotBookingSystem chatBotBookingSystem;

    // ✅ Explicit Constructor (Ensures Spring injects the dependency correctly)
    public ChatBotController(ChatBotBookingSystem chatBotBookingSystem) {
        this.chatBotBookingSystem = chatBotBookingSystem;
    }

    @PostMapping(value = "/chatbot/message", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ChatBotResponse> message(@RequestBody ChatBotRequest request) {
        String answer = chatBotBookingSystem.answer(request.getMemoryId(), request.getMessage());
        return ResponseEntity.ok(new ChatBotResponse(request.getMemoryId(), answer));
    }


    //adding extra things
    @PostMapping("/chatbot/book")
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

}
