package com.edufire.rr.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {
    private int studentId;
    private static HashMap<String, Student> students;
    static {
        students = new HashMap<>();
    }
    private static ArrayList<Class> classes;

    public Student(String username, String password, String completeName,int studentId) {
        super(username, password, completeName,true);
        this.studentId=studentId;
        students.put(username,this);
        classes = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }
    public static Student getStudent(String username) {
        return students.get(username);
    }

    public static ArrayList<Class> getClasses() {
        return classes;
    }

    public static void joinClass(Class classToJoin){
        classes.add(classToJoin);
    }
}
