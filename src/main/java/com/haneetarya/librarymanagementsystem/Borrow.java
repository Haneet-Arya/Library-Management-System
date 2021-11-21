package com.haneetarya.librarymanagementsystem;

public class Borrow {
    int sid,bid;
    String bname;
    String sname;
    String author;
    String publisher;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Borrow(int sid, int bid, String bname, String sname, String author, String publisher, String phone) {
        this.sid = sid;
        this.bid = bid;
        this.bname = bname;
        this.sname = sname;
        this.author = author;
        this.publisher = publisher;
        this.phone = phone;
    }

    String phone;
}
