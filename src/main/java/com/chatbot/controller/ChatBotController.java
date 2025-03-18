package com.chatbot.controller;

import com.chatbot.ai.ChatBotBookingSystem;
import com.chatbot.dto.ChatBotRequest;
import com.chatbot.dto.ChatBotResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotController {

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
}
