//package com.chatbot.services;
//
//import dev.langchain4j.data.message.AiMessage;
//import dev.langchain4j.data.message.ChatMessage;
//import dev.langchain4j.model.chat.ChatLanguageModel;
//import dev.langchain4j.model.output.Response;
//
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.List;
//
//public class GeminiChatModel implements ChatLanguageModel {
//
//    private static final String API_KEY = "AIzaSyC17CnxBToFypFEvvbYawYxZtuZrqi4hhQ";
//    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=AIzaSyC17CnxBToFypFEvvbYawYxZtuZrqi4hhQ";
//
//    private final HttpClient httpClient = HttpClient.newHttpClient();
//
//    @Override
//    public Response<AiMessage> generateResponse(List<ChatMessage> messages) {
//        String prompt = messages.get(messages.size() - 1).toString();
//
//        String jsonBody = """
//        {
//          "contents": [{
//            "parts": [{
//              "text": "%s"
//            }]
//          }]
//        }
//        """.formatted(prompt);
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(API_URL))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
//                .build();
//
//        try {
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//            String responseBody = response.body();
//            String aiResponse = extractContent(responseBody);
//
//            return Response.from(new AiMessage(aiResponse));
//        } catch (Exception e) {
//            return Response.from(new AiMessage("Error: " + e.getMessage()));
//        }
//    }
//
//    private String extractContent(String json) {
//        int start = json.indexOf("\"text\":\"") + 8;
//        int end = json.indexOf("\"", start);
//        if (start == -1 || end == -1 || end <= start) {
//            return "Could not parse Gemini response.";
//        }
//        return json.substring(start, end).replace("\\n", "\n");
//    }
//}
