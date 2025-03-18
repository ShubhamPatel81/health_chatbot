package com.chatbot.config;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration  
public class ChatBotConfig {

    @Bean
    public OllamaChatModel chatLanguageModel() {
        return OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("mistral")
                .timeout(Duration.ofMinutes(20))
                .build();
    }
}
