package com.chatbot.repository;



import com.chatbot.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageRepository extends CrudRepository<Message, UUID> {
    Optional<Message> findByMemoryId(String memoryId);

    void deleteByMemoryId(String memoryId);
}
