package UtileS.DatetoFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Student {

    private int id;
    private String username;

    //方法1
    //@DateTimeFormat(pattern = "yyyy-MM-dd")

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Student() {
    }

    public Student(int id, String username, Date birthday) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
