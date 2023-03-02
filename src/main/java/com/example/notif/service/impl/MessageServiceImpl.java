package com.example.notif.service.impl;

import com.example.notif.dto.MessageResponse;
import com.example.notif.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    @Autowired
    private final SimpMessagingTemplate messagingTemplate;

    public void sendMessageToAll() {
        MessageResponse message = new MessageResponse("Sent to all");
        messagingTemplate.convertAndSend("/topic/all", message);
    }

    public void sendMessageToUser(String name) {
        MessageResponse message = new MessageResponse("Sent to specific user");
        messagingTemplate.convertAndSendToUser(name,"/topic/private", message);
    }


}
