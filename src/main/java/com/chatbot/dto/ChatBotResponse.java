package com.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
public class ChatBotResponse {
    private String memoryId;
    private String responseMessage;

    // No-argument constructor (needed for Jackson)
    public ChatBotResponse() {}

    // Constructor with arguments
    public ChatBotResponse(String memoryId, String responseMessage) {
        this.memoryId = memoryId;
        this.responseMessage = responseMessage;
    }

    public String getMemoryId() {
        return memoryId;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
