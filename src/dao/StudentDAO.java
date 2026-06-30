package dao;

import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public void addStudent(Student student) {

        String query = "INSERT INTO students(name, age, course, email) VALUES (?, ?, ?, ?)";
        try(   Connection conn = DBConnection.getConnection();

            PreparedStatement st = conn.prepareStatement(query)) {

            st.setString(1,student.getName());
            st.setInt(2,student.getAge());
            st.setString(3,student.getCourse());
            st.setString(4, student.getEmail());
            int rowsAffected=st.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Student Added Successfully");
            }


        }catch (SQLException e){
            System.out.println("Error inserting student");
            e.printStackTrace();
        }
    }
}