package com.haneetarya.librarymanagementsystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public static ObservableList<Student> studentList(){
        String query = "select * from student";
        ObservableList<Student> ls = FXCollections.observableArrayList();
        try {
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                ls.add(new Student(Integer.toString(rs.getInt("sid")), rs.getString("sname"), rs.getString("phone")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }
    public static ObservableList<Borrow> borrowList(){
        String query = "SELECT * from student natural join(borrow natural join book);";
        ObservableList<Borrow> ls = FXCollections.observableArrayList();
        try {
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                ls.add(new Borrow(rs.getInt("sid"), rs.getInt("bid"), rs.getString("bname")
                        , rs.getString("sname"), rs.getString("bauthor"), rs.getString("bpublisher"),
                        rs.getString("phone")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }
public static ObservableList<Book> bookList(){
        String query = "select * from book";
        ObservableList<Book> ls = FXCollections.observableArrayList();
        try {
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                ls.add(new Book(rs.getInt("bid"), rs.getString("bname"), rs.getString("bauthor"), rs.getString("bpublisher")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls;
    }

    public static String submitBook(String sid, String bid){
        String query = "delete from borrow where bid = '"+bid+"' and sid = '"+sid+"';";
        String query1 = "select sname,bname from student natural join(borrow natural join book) where bid = '" + bid + "' and sid ='" + sid + "';";
        try {

            String ret="";
            if(checkBook(bid) && checkStudent(sid)){
                ResultSet rs = s.executeQuery(query1);
                if(rs.next()){
                    ret = rs.getString("bname") + " has been submitted by " + rs.getString("sname");
                    s.execute(query);
                    return ret;
                }
                else {
                    ret = "This book is not issued to the Student";
                    return ret;
                }
            }
            else {
                return "Student or Book not registered";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FALSE;
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
            if(checkStudent(sid) && checkBook(bid)){
                s.execute(query);
                ResultSet rs = s.executeQuery(query1);
                String ret = "";
                while (rs.next())
                {
                    ret = rs.getString("sname")+","+rs.getString("bname");

                }
                String[] r = ret.split(",");
                return r[1] + " has been borrowed by " + r[0];
            }
            else
                return  "Book or Student not registered";


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
    public static boolean checkStudent(String sid){
        String query = "select * from student where sid = '"+sid+"';";
        ResultSet rs;
        try {
            Statement s2 = con.createStatement();
            rs = s2.executeQuery(query);
            if(rs.next()){
                rs.close();
                return true;
            }
            rs.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
    public static boolean checkBook(String bid){
        String query = "select * from book where bid = '"+bid+"';";

        try {
            Statement s1 = con.createStatement();
            ResultSet rs = s1.executeQuery(query);
            if(rs.next()){
                return true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
