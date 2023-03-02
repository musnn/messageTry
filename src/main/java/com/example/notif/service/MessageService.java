package com.example.notif.service;

public interface MessageService {
    void sendMessageToAll();
    void sendMessageToUser(String name);
}