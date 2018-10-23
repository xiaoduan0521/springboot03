package com.xd.entity;

import java.util.Arrays;
import java.util.Date;

public class Student {
    private int id;
    private String name;
    private Date join;
    private java.sql.Date birth;
    private String sex;
    private String[] hobby;

    public Student() {
    }

    public Student(String name, Date join, java.sql.Date birth, String sex, String[] hobby) {
        this.name = name;
        this.join = join;
        this.birth = birth;
        this.sex = sex;
        this.hobby = hobby;
    }

    public Student(int id, String name, Date join, java.sql.Date birth, String sex, String[] hobby) {
        this.id = id;
        this.name = name;
        this.join = join;
        this.birth = birth;
        this.sex = sex;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", join=" + join +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoin() {
        return join;
    }

    public void setJoin(Date join) {
        this.join = join;
    }

    public java.sql.Date getBirth() {
        return birth;
    }

    public void setBirth(java.sql.Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}
