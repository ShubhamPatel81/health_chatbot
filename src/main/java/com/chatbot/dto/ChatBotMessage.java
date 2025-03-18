package com.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageType;
import java.util.LinkedList;
import java.util.List;
import static dev.langchain4j.data.message.ChatMessageDeserializer.messagesFromJson;
@Getter
@Setter
@NoArgsConstructor
public class ChatBotMessage {

    private String memoryId;
    private String message;
    private boolean isUser;

    // ✅ Manually defined constructor to fix the error
    public ChatBotMessage(String memoryId, String message, boolean isUser) {
        this.memoryId = memoryId;
        this.message = message;
        this.isUser = isUser;
    }

    public static List<ChatBotMessage> fromJson(String memoryId, String messages) {
        final List<ChatBotMessage> chatBotMessages = new LinkedList<>();
        List<ChatMessage> chatMessages = messagesFromJson(messages);
        chatMessages.forEach(chatMessage ->
                chatBotMessages.add(new ChatBotMessage(
                        memoryId,
                        chatMessage.text(), // ✅ Ensure `text()` method exists
                        chatMessage.type().equals(ChatMessageType.USER)
                ))
        );
        return chatBotMessages;
    }
}
