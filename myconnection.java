package project;

import java.sql.*;


public class myconnection {
    public static Connection getConnection() 
    {
        Connection con= null;
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce","root","123456");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;
        } 
}