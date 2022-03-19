package com.edufire.rr.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {
    private int studentId;
    private static HashMap<String, Student> students=new HashMap<>();;
    private  ArrayList<String> courses = new ArrayList<>();//save course names instead of object(course name is unique) and we can get Course by it's name

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

    public ArrayList<Course> getCourses() {
        ArrayList<Course> studentsCourses = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            studentsCourses.add(Course.getCourseByName(courses.get(i)));
        }
        return studentsCourses;
    }

    public void joinClass(Course courseToJoin) {
        courses.add(courseToJoin.getName());
    }//////I have changed

    public static HashMap<String, Student> getAllStudents() {
        return students;
    }

    public static void setStudents(HashMap<String, Student> students) {
        Student.students = students;
    }

    public ArrayList<Course> getAvailableCourses(){///I have changed
        Log.d("in", "im in");
        if (courses.isEmpty()){
            return Course.getCoursesArrayList();
        }else{
            ArrayList<Course> studentsCourses = new ArrayList<>(getCourses());
            ArrayList<Course> allCourses = new ArrayList<>(Course.getCoursesArrayList());
            ArrayList<Course> union = new ArrayList<>(studentsCourses);
            union.addAll(allCourses);
            ArrayList<Course> interSection = new ArrayList<>(allCourses);
            interSection.retainAll(studentsCourses);
            ArrayList<Course> symmetricDifference = new ArrayList<>(union);
            symmetricDifference.removeAll(interSection);
            return symmetricDifference;
        }
    }

}
