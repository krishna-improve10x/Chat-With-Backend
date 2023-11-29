package com.example.database.chatwithbackend.messages;

import com.example.database.chatwithbackend.common.DatabaseManager;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessagesDbManager extends DatabaseManager {

    public List<Message> getMessages(){
        try {
            List<Message> messages = (List<Message>) runQuery("SELECT  * FROM Message");
            return messages;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Object convertToObject(ResultSet resultSet) throws SQLException{
        List<Message> messages = new ArrayList<>();
        while (resultSet.next()){
            Message message = new Message();
            message.MessageId = resultSet.getInt(1);
            message.name = resultSet.getString(2);
            message.mobileNumber = resultSet.getString(3);
            message.messageText = resultSet.getString(4);
            messages.add(message);
        }
        return messages;
    }
}
