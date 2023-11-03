package com.example.database.tables.template;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbManager {

    public List<Template> getTemplates() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String name = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Template");
            List<Template> templates = new ArrayList<>();
            while (resultSet.next()) {
                Template template = new Template();
                template.templateId = resultSet.getInt(1);
                template.name = resultSet.getString(2);
                template.messageText = resultSet.getString(3);
                templates.add(template);
            }
            connection.close();
            return templates;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}