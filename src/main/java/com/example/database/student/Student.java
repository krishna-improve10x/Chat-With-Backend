package com.example.database.student;

public class Student {

    public String studentId;
    public String firstname;
    public String lastname;
    public String dateOfBirth;
    public String email;
    public String major;
    public int graduationYear;

//    @GetMapping(value = "studentNames", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<String> getStudentNames(){
//        List<String>  studentNames = new ArrayList<>();
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://db4free.net:3306/improve10x";
//            String username = "trainee10x";
//            String password = "12345678";
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//          ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
//          while (resultSet.next()){
//              String firstname = resultSet.getString(2);
//              studentNames.add(firstname);
//          }
//          connection.close();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return studentNames;
//    }
}
