package com.peters.Chat.websocket.repository;


import com.peters.Chat.websocket.chat.ChatMessages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessages, Long> {
    List<ChatMessages> findByChatId(String s);
}
