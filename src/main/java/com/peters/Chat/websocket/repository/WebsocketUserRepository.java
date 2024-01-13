package com.peters.Chat.websocket.repository;


import com.peters.Chat.websocket.dto.Status;
import com.peters.Chat.websocket.user.WebSocketUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebsocketUserRepository extends JpaRepository<WebSocketUser, String> {
    List<WebSocketUser> findAllByStatus(Status status);
}
