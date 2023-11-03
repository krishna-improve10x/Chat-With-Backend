package com.example.database.Employee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Employees {

    @GetMapping(value = "employee/{salary}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees(@PathVariable("salary") int salary){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee where salary = "+salary+" ");
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.employeeId = resultSet.getInt(1);
                employee.firstname = resultSet.getString(2);
                employee.lastname = resultSet.getString(3);
                employee.email =  resultSet.getString(4);
                employee.hireDate = resultSet.getString(5);
                employee.salary = resultSet.getInt(6);
                employees.add(employee);
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
