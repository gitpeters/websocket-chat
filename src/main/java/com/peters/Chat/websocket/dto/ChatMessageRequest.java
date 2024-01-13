package com.peters.Chat.websocket.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ChatMessageRequest {
    private String chatId;
    private String senderId;
    private String recipientId;
    private String content;
    private Date timestamp;

}
