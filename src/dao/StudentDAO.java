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
    public Student searchStudentById(int ID) {
        String Query = "SELECT * FROM students WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(Query)) {
           ps.setInt(1,ID);
            ResultSet rs=ps.executeQuery();
           if(rs.next()){
               int ids=rs.getInt("id");
               String names= rs.getString("name");
               int age=rs.getInt("age");
               String course=rs.getString("course");
               String email=rs.getString("email");
               Student stu=new Student(ids,names,age,course,email);
               return stu;

           }

        } catch (SQLException ex) {
            System.out.println("search Exception Occured");
            throw new RuntimeException(ex);
        }
        return null;
    }
    public List<Student> searchStudentByName(String name){
        List<Student> Students=new ArrayList<>();
        final String query="SELECT * FROM students WHERE name =?";
        try(Connection con= DBConnection.getConnection();
        PreparedStatement st=con.prepareStatement(query)){

            st.setString(1,name);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                int ids=rs.getInt("id");
                String names= rs.getString("name");
                int age=rs.getInt("age");
                String course=rs.getString("course");
                String email=rs.getString("email");
                Student stu=new Student(ids,names,age,course,email);
                Students.add(stu);

            }

        } catch (SQLException e) {
            System.out.println("SearchByName Exception");
            throw new RuntimeException(e);
        }
        return Students;
    }
    public boolean updateStudents(Student student){
        final String query="UPDATE students SET name=?,age=?,course=?,email=? WHERE id=? ";
        try(Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(query)){
            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getCourse());
            ps.setString(4,student.getEmail());
            ps.setInt(5,student.getId());
            int RowsAffected=ps.executeUpdate();
            return RowsAffected>0;

        }catch(SQLException e){
            System.out.println("Update Exception Occured");
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteStudentsById(int id){
        final String query="DELETE FROM students WHERE id=?";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(query)){
            ps.setInt(1,id);
            int rowsAffected=ps.executeUpdate();
            return rowsAffected>0;

        }catch(SQLException e){
            System.out.println("Delete Exception Occuured");
            e.printStackTrace();
        }

        return  false;
    }
}