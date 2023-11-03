package com.example.database.tables.dbConnection.message;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseManager {

    public List<Message> saveMessageData(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM Message");
            List<Message> messageList = new ArrayList<>();
            while (resultSet.next()){
                Message message = new Message();
                message.MessageId = resultSet.getInt(1);
                message.name = resultSet.getString(2);
                message.mobileNumber = resultSet.getString(3);
                message.messageText = resultSet.getString(4);
                messageList.add(message);
            }
            connection.close();
            return messageList;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
