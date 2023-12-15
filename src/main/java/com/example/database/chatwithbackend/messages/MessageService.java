package com.example.database.chatwithbackend.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessagesDbManager messagesDbManager;

    public List<Message> getMessages() {
        return messagesDbManager.getMessages();
    }

    public int updateMessage(int messageId, String name, String mobileNumber) {
        return messagesDbManager.updateMessage(messageId, name, mobileNumber);
    }

    public void deleteMessage(int messageId) {
        messagesDbManager.deleteMessage(messageId);
    }
}