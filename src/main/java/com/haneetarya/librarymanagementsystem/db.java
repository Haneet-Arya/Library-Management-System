package com.haneetarya.librarymanagementsystem;
import java.sql.*;

public class db {
    public static Connection con;
    public static Statement s;
    public static String FALSE="1";
    public static String True="0";

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
    public static String insertStudent(String name, String phone){
        String query = "insert into student(sname, phone) values('"+name+"','"+phone+"');";
        String query1 = "select sid from student where phone='"+phone+"';";
        try {
            s.execute(query);
            ResultSet rs = s.executeQuery(query1);
            String id = "";
            while (rs.next())
            {
                id = rs.getString("sid");

            }
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FALSE;
    }

    public static String issueBook(String sid, String bid){
        String query = "insert into borrow(bid, sid) values('"+bid+"','"+sid+"');";
        String query2 = "select * from borrow where bid='"+bid+"';";
        String query1 = "select sname,bname from student natural join(borrow natural join book) where bid = '"+bid+"';";
        try {
            ResultSet rs1 = s.executeQuery(query2);
            if(rs1.next()){
                ResultSet rs = s.executeQuery(query1);
                String ret = "";
                rs.next();
                ret = rs.getString("sname");
                return "This Book has been already borrowed by " + ret;
            }
            s.execute(query);
            ResultSet rs = s.executeQuery(query1);
            String ret = "";
            while (rs.next())
            {
                ret = rs.getString("sname")+","+rs.getString("bname");

            }
            String[] r = ret.split(",");
            return r[1] + " has been borrowed by " + r[0];

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FALSE;
    }

    public static String insertBook(String name, String author,String publisher){
        String query = "insert into book(bname, bauthor,bpublisher) values('"+name+"','"+author+"','"+publisher+"');";
        String query1 = "select bid from book where bauthor='"+author+"' and bpublisher='"+publisher+"';";
        try {
            s.execute(query);
            ResultSet rs = s.executeQuery(query1);
            String id = "";
            while (rs.next())
            {
                id = rs.getString("bid");

            }
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FALSE;
    }

}
