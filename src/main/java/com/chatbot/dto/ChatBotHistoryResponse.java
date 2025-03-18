package com.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ChatBotHistoryResponse {
    private String memoryId;
    private List<ChatBotMessage> messages;

    // No-argument constructor
    public ChatBotHistoryResponse() {}

    // Constructor with parameters
    public ChatBotHistoryResponse(String memoryId, List<ChatBotMessage> messages) {
        this.memoryId = memoryId;
        this.messages = messages;
    }

    public String getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(String memoryId) {  // ✅ Manually added setter
        this.memoryId = memoryId;
    }

    public List<ChatBotMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatBotMessage> messages) {
        this.messages = messages;
    }
}
