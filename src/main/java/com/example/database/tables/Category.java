package com.example.database.tables;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Category {

    public String name;

    @GetMapping(value = "category", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getCategories(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Categories");
            List<String> categories = new ArrayList<>();
            while (resultSet.next()){
               name = resultSet.getString(1);
               categories.add(name);
            }
            connection.close();
            return categories;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
