package com.example.database.tables.dbConnection.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("v1")
@RequestMapping("v1")
public class MessageController {

    @Autowired
     MessageService messageService;

    @GetMapping(value = "listOfMessages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessages(){
        return messageService.getMessages();
    }
}
