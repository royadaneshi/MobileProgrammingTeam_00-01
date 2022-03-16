package com.edufire.rr.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {
    private int studentId;


    private static HashMap<String, Student> students=new HashMap<>();;

    private static ArrayList<Course> cours;

    public Student(String username, String password, String completeName, int studentId) {
        super(username, password, completeName, true);
        this.studentId = studentId;
        cours = new ArrayList<>();
        students.put(username, this);
    }

    public int getStudentId() {
        return studentId;
    }

    public static Student getStudent(String username) {
        return students.get(username);
    }

    public ArrayList<Course> getClasses() {
        return cours;
    }

    public static void joinClass(Course courseToJoin) {
        cours.add(courseToJoin);
    }

    public static HashMap<String, Student> getAllStudents() {
        return students;
    }

    public static void setStudents(HashMap<String, Student> students) {
        Student.students = students;
    }

}
