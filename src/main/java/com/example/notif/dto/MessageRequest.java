package com.example.notif.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private Long userId;
    private String content;
}
