package com.peters.Chat.websocket.service;


import com.peters.Chat.websocket.dto.WebSocketUserRequest;
import com.peters.Chat.websocket.repository.WebsocketUserRepository;
import com.peters.Chat.websocket.user.WebSocketUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.peters.Chat.websocket.dto.Status.OFFLINE;
import static com.peters.Chat.websocket.dto.Status.ONLINE;


@Service
@RequiredArgsConstructor
public class WebSocketUserService {

    private final WebsocketUserRepository userRepository;
    public WebSocketUser saveUser(WebSocketUser user){
        user.setStatus(ONLINE);
       return userRepository.save(user);
    }

    public void disconnect(WebSocketUser user){
        var connectedUser = userRepository.findById(user.getNickName())
                .orElse(null);
        if(connectedUser !=null){
            connectedUser.setStatus(OFFLINE);
            userRepository.save(connectedUser);
        }
    }

    public List<WebSocketUser> findConnectedUsers(){
        return userRepository.findAllByStatus(ONLINE);
    }
}
