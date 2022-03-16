package com.edufire.rr.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {
    private int studentId;


    private static HashMap<String, Student> students=new HashMap<>();;

    private  ArrayList<Course> courses = new ArrayList<>();

    public Student(String username, String password, String completeName, int studentId) {
        super(username, password, completeName, true);
        this.studentId = studentId;
        courses = new ArrayList<>();
        students.put(username, this);
    }

    public int getStudentId() {
        return studentId;
    }

    public static Student getStudent(String username) {
        return students.get(username);
    }

    public ArrayList<Course> getClasses() {
        return courses;
    }

    public void joinClass(Course courseToJoin) {
        courses.add(courseToJoin);
    }//////

    public static HashMap<String, Student> getAllStudents() {
        return students;
    }

    public static void setStudents(HashMap<String, Student> students) {
        Student.students = students;
    }

    public ArrayList<Course> getAvailableCourses(){///
        ArrayList<Course> studentsCourses = new ArrayList<>(courses);
        ArrayList<Course> allCourses = new ArrayList<>(Course.getCoursesArrayList());
        ArrayList<Course> union = new ArrayList<>(studentsCourses);
        union.addAll(allCourses);
        ArrayList<Course> interSection = new ArrayList<>(allCourses);
        ArrayList<Course> symetricDiffrence = new ArrayList<>(union);
        symetricDiffrence.removeAll(interSection);
        return symetricDiffrence;
    }

}
