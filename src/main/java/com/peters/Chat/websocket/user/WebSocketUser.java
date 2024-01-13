package com.peters.Chat.websocket.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.peters.Chat.websocket.dto.Status;
import jakarta.persistence.*;
import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.time.Instant;

@Data
@Entity
@Table(name = "chat_user")
public class WebSocketUser {
    @Id
    private String nickName;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private Status status;

    @CreatedDate
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate;
}
