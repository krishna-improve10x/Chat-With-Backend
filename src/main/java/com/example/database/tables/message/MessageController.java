package com.example.database.tables.message;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {

    @GetMapping(value = "listOfMessages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessageList(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String name = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Message");
            List<Message> messages = new ArrayList<>();
            while (resultSet.next()){
                Message message = new Message();
                message.messageId = resultSet.getInt(1);
                message.name = resultSet.getString(2);
                message.mobileNumber = resultSet.getString(3);
                message.messageText = resultSet.getString(4);
                messages.add(message);
            }
            connection.close();
            return messages;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
