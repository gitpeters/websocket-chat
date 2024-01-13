package com.peters.Chat.websocket.controller;


import com.peters.Chat.websocket.service.WebSocketUserService;
import com.peters.Chat.websocket.user.WebSocketUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class WebSocketUserController {
    private final WebSocketUserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public WebSocketUser addUser(
            @Payload WebSocketUser user
    ) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public WebSocketUser disconnectUser(
            @Payload WebSocketUser user
    ) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<WebSocketUser>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
