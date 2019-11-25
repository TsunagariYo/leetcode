package UtileS.ExportToExcel;

import java.util.Date;

public class Student {
    private String username;
    private String password;
    private int age;
    private Date date;

    public Student(String username, String password, int age, Date date) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
