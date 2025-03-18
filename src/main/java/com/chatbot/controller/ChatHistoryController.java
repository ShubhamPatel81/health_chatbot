package com.chatbot.controller;



import com.chatbot.dto.ChatBotHistoryResponse;
import com.chatbot.dto.ChatBotMessage;
import com.chatbot.model.Message;
import com.chatbot.model.Message.*;

import com.chatbot.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ChatHistoryController {
    @Autowired
    private  MessageRepository messageRepository;

    @GetMapping(value = "/message/history", produces = "application/json")
    public ResponseEntity<ChatBotHistoryResponse> message(@RequestParam String memoryId) {
        Optional<Message> messages = messageRepository.findByMemoryId(memoryId);
        if (messages.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ChatBotHistoryResponse response = new ChatBotHistoryResponse();
        response.setMemoryId(memoryId);

        messages.ifPresent(message -> {
            List<ChatBotMessage> chatBotMessages = ChatBotMessage.fromJson(memoryId, message.getMessages());
            response.setMessages(chatBotMessages);
        });

        return ResponseEntity.ok(response);
    }
}
