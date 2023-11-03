package com.example.database.tables.dbConnection.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    DatabaseManager databaseManager;
    public List<Message> getMessages(){
        return databaseManager.saveMessageData();
    }
}
