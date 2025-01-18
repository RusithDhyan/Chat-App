package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage chatMessage(ChatMessage message) {
        System.out.println("Backend received message: " + message.getContent() + " from " + message.getSender());
        return message;  // This message should be sent to /topic/messages
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}
