package com.peters.Chat.websocket.dto;

import lombok.Data;

@Data
public class WebSocketUserRequest {
    private String nickName;
    private String fullName;
}
