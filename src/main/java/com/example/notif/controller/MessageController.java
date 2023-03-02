package com.example.notif.controller;

import com.example.notif.dto.MessageRequest;
import com.example.notif.model.User;
import com.example.notif.service.MessageService;
import com.example.notif.dto.Message;
import com.example.notif.dto.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public MessageResponse getMessage(Message message){
        messageService.sendMessageToAll();
        return new MessageResponse(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

    @MessageMapping("/private-message")
    @SendToUser("/topic/private-messages")
    public MessageResponse getPrivateMessage(Message message, User user) {
        messageService.sendMessageToUser(user.getName());
        return new MessageResponse(HtmlUtils.htmlEscape(
                "Send to user named **" + user.getName() + "** : "
                        + message.getMessageContent())
        );
    }

//    public ResponseEntity<MessageResponse> getNotification(@RequestBody MessageRequest message) {
//
//    }
}
