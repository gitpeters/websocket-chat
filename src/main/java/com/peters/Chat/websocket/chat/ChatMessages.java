package com.peters.Chat.websocket.chat;


import com.peters.Chat.websocket.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ChatMessages extends BaseEntity {
    private String chatId;
    private String senderId;
    private String recipientId;
    private String content;
    private Date timestamp;
}
