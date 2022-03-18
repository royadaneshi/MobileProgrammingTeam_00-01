package com.edufire.rr.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Exercise {


    private String name;
    private Course course;
    private String answer;
    private Professor professor;

    private static HashMap<String, Exercise> exercises = new HashMap<>();

    public Exercise(String name, Course course,  Professor professor) {
        this.name = name;
        this.professor = professor;
        this.course = course;
        exercises.put(name, this);
    }
    public String getNameOfExercise() {
        return name;
    }
    public Course getCourseOfExercise() {
        return course;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public Professor getProfessorOfExercise() {
        return professor;
    }

    public static HashMap<String, Exercise> getExercises() {
        return exercises;
    }

    public static Exercise getExerciseByName(String name) {
        return exercises.get(name);
    }
}
