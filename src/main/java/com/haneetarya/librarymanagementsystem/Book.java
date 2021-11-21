package com.haneetarya.librarymanagementsystem;

public class Book {
    int id;
    String bookName;
    String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public Book(int id, String bookName, String author, String publisher) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
    }

    String publisher;
}
