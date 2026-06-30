package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL="jdbc:mysql://localhost:3306/studentdb";
    private static final String USER="root";
    private static final String PASS="MySQLummera@123";

    public static Connection getConnection(){
        try{
            Connection conn=DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connected to database successfully");
            return conn;

        }catch(SQLException e){
            System.out.println("DATABASE CONNECTION FAILED");
            e.printStackTrace();
            return null;
        }
    }

}
