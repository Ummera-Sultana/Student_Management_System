package dao;

import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util. ArrayList;
import java.sql.ResultSet;

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
    public List<Student>  viewStudents(){
        List<Student> lis=new ArrayList<>();
        String query= "SELECT * FROM students";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(query)){
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                int ids=rs.getInt("id");
                String names= rs.getString("name");
                int age=rs.getInt("age");
                String course=rs.getString("course");
                String email=rs.getString("email");
                Student stu=new Student(ids,names,age,course,email);
                lis.add(stu);
            }

        }catch(SQLException e){
            System.out.println("viewstuednts Exception occurred");
            e.printStackTrace();
        }
   return lis;
    }
}