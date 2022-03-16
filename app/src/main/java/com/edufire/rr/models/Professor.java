package com.edufire.rr.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends User {
    private String universityName;


    private static HashMap<String, Professor> professors= new HashMap<>();;
    private static ArrayList<Class> classes;


    public Professor(String username, String password, String completeName, String universityName) {
        super(username, password, completeName, false);
        this.universityName = universityName;
        classes = new ArrayList<>();
        professors.put(username, this);
    }

    public String getUniversityName() {
        return universityName;
    }

    public static Professor getProfessor(String username) {
        return professors.get(username);
    }

    public static void addNewClass(Class newClass) {
        classes.add(newClass);
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public static HashMap<String, Professor> getAllProfessors() {
        return professors;
    }

    public static void setProfessors(HashMap<String, Professor> professors) {
        Professor.professors = professors;
    }

}
