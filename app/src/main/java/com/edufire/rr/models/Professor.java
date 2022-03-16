package com.edufire.rr.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends User {
    private String universityName;
    private static HashMap<String, Professor> professors = new HashMap<>();
    private static ArrayList<Course> courses;


    public Professor(String username, String password, String completeName, String universityName) {
        super(username, password, completeName, false);
        this.universityName = universityName;
        courses = new ArrayList<>();
        professors.put(username, this);
    }

    public String getUniversityName() {
        return universityName;
    }

    public static Professor getProfessor(String username) {
        return professors.get(username);
    }

    public static void addNewClass(Course newCourse) {////
        if (courses == null) {
            courses = new ArrayList<>();
        } else {
            courses.add(newCourse);
        }

    }

    public ArrayList<Course> getClasses() {
        return courses;
    }

    public static HashMap<String, Professor> getAllProfessors() {
        return professors;
    }

    public static void setProfessors(HashMap<String, Professor> professors) {
        Professor.professors = professors;
    }

}
