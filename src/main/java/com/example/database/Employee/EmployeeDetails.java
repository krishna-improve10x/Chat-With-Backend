package com.example.database.Employee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeDetails {

    @GetMapping(value = "getEmployeeDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getDetails(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("INSERT INTO employee (first_name, last_name, email, hire_date, salary)  VALUES ('krishna', 'gangimeni', 'krishna123@gmail.com',  '1998_01_14', 60000.00)");
            ArrayList<Employee> employees = new ArrayList<>();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.firstname = resultSet.getString(1);
                employee.lastname = resultSet.getString(2);
                employee.email = resultSet.getString(3);
                employee.hireDate = resultSet.getString(4);
                employee.salary = resultSet.getFloat(5);
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
