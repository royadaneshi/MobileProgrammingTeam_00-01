package com.edufire.rr.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Class {
    private final String name;
    private final Professor professor;
    private final ArrayList<Student> students;
    private static final HashMap<String,Class> classes ;

    static {
        classes = new HashMap<>();
    }

    public Class(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
        students = new ArrayList<>();
        classes.put(name,this);
        Professor.addNewClass(this);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public HashMap<String, Class> getClasses() {
        return classes;
    }

}
