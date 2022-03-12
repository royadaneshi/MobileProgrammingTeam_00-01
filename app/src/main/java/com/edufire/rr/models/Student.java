package com.edufire.rr.models;

import java.util.HashMap;

public class Student extends User {
    private int studentId;
    private static HashMap<String, Student> students;
    static {
        students = new HashMap<>();
    }

    public Student(String username, String password, String completeName,int studentId) {
        super(username, password, completeName,true);
        this.studentId=studentId;
        students.put(username,this);

    }

    public int getStudentId() {
        return studentId;
    }
    public static Student getStudent(String username) {
        return students.get(username);
    }
}
