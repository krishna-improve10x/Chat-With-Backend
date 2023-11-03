package com.example.database.Employee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping(value = "employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getEmployeeDetails(@PathVariable("employeeId") int employeeId){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT first_name FROM employee where employee_id = "+employeeId+"");
            List<String> employees = new ArrayList<>();
            while (resultSet.next()){
               String firstname = resultSet.getString(1);
               employees.add(firstname);
            }
            connection.close();
            return employees;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
