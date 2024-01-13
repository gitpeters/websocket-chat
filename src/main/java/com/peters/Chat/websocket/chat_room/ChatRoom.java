package com.peters.Chat.websocket.chat_room;


import com.peters.Chat.websocket.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ChatRoom extends BaseEntity {
    private String chatId;
    private String senderId;
    private String recipientId;
}
