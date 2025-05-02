package com.chatbot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "message")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;


    private String memoryId;
    @Column(columnDefinition = "TEXT")
    private String messages;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", memoryId='" + memoryId + '\'' +
                ", messages='" + messages + '\'' +
                '}';
    }

    public Message(String memoryId, String messages) {
        this.memoryId = memoryId;
        this.messages = messages;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(String memoryId) {
        this.memoryId = memoryId;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Message() {
    }

    public Message(UUID id, String memoryId, String messages) {
        this.id = id;
        this.memoryId = memoryId;
        this.messages = messages;
    }



    public Message(UUID id) {
        this.id = id;
    }
}
