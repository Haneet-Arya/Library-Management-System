package com.haneetarya.librarymanagementsystem;

public class Student {
    public String id, name, phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Student(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
