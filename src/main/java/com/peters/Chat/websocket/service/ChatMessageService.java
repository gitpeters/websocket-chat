package com.peters.Chat.websocket.service;


import com.peters.Chat.websocket.chat.ChatMessages;
import com.peters.Chat.websocket.dto.ChatMessageRequest;
import com.peters.Chat.websocket.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    public ChatMessages save (ChatMessages chatMessages){
        var chatId = chatRoomService.getChatRoomId(chatMessages.getSenderId(), chatMessages.getRecipientId(), true).orElseThrow();
        chatMessages.setChatId(chatId);
        return repository.save(chatMessages);
    }

    public List<ChatMessages> findChatMessages(String senderId, String recipientId){
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}
