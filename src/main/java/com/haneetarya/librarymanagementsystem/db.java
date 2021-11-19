package com.haneetarya.librarymanagementsystem;
import java.sql.*;

public class db {
    public static Connection con;
    public static Statement s;

    public static boolean logIn(String userId, String pwd){
        try {
            con = DriverManager.getConnection("jdbc:mysql://172.16.233.3:3306/Library",userId,pwd);
            s= con.createStatement();
            System.out.println("Success");
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static void logOut(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean inserStudent(String name, String phone){
        String query = "insert into student(sname, phone) values('"+name+"','"+phone+"');";
        try {
            s.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
