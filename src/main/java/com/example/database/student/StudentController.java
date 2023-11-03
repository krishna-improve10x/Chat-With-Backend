package com.example.database.student;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping(value = "students/{graduation_year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudentNames(@PathVariable("graduation_year") int graduationYear){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db4free.net:3306/improve10x";
            String username = "trainee10x";
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student where graduation_year = "+graduationYear +" order by first_name");
            List<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Student student = new Student();
                student.studentId = resultSet.getString(1);
                student.firstname = resultSet.getString(2);
                student.lastname = resultSet.getString(3);
                student.dateOfBirth = resultSet.getString(4);
                student.email = resultSet.getString(5);
                student.major = resultSet.getString(6);
                student.graduationYear = resultSet.getInt(7);
                students.add(student);
            }
            connection.close();
            return students;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


