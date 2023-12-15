package com.example.database.chatwithbackend.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("v1")
@RequestMapping("v1")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(value = "listOfMessages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

    @PutMapping(value = "updateMessage/{id}/name/", produces = MediaType.APPLICATION_JSON_VALUE)
    public int updateMessage(@PathVariable("id") int messageId, @RequestParam("name") String name, @RequestParam String mobileNumber) {
        return messageService.updateMessage(messageId, name, mobileNumber);
    }

    @DeleteMapping(value = "deleteMessage/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteMessage(@PathVariable("id") int messageId){
        messageService.deleteMessage(messageId);
    }
}