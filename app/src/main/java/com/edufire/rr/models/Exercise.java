package com.edufire.rr.models;

import android.content.Context;

import com.edufire.rr.DataBase;

import java.util.ArrayList;
import java.util.HashMap;

public class Exercise {


    private String name;
    private Course course;
    private String answer;
    private Professor professor;
    private String grade;



    private ArrayList<String> studentsAnswers = new ArrayList<>();//students name of this exercise
    private static HashMap<String, Exercise> exercises = new HashMap<>();

    public Exercise(String name, Course course, Professor professor) {
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

    public void setAnswer(String answer, String studentName) {
        this.answer = answer;
        if(studentsAnswers==null){
            studentsAnswers=new ArrayList<>();
        }
        studentsAnswers.add(studentName);
    }

    public void setStudentsAnswers(ArrayList<String> studentsAnswers) {
        this.studentsAnswers = studentsAnswers;
    }

    public static void setExercises(HashMap<String, Exercise> exercises) {
        Exercise.exercises = exercises;
    }

    public void setNameExercise(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public Professor getProfessorOfExercise() {
        return professor;
    }

    public static HashMap<String, Exercise> getExercises() {
        if(exercises ==null){
            exercises=new HashMap<>();
        }
        return exercises;
    }

    public static Exercise getExerciseByName(String name) {
        return exercises.get(name);
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        System.out.println("before set"+getGrade());
        this.grade = grade;
        System.out.println("after set"+getGrade());
    }

    public HashMap<String, Exercise> getStudentsAnswersByExerciseValue() {
        HashMap<String,Exercise> newHash=new HashMap<>();
//        ArrayList<String> exercisesName=new ArrayList<>(studentsAnswers.values());
//        ArrayList<String> studentsName=new ArrayList<>(studentsAnswers.keySet());
        for (int i = 0; i < studentsAnswers.size(); i++) {
            newHash.put(studentsAnswers.get(i),this);
        }
        return newHash;
    }
    public ArrayList<String> getStudentsAnswers() {
        return studentsAnswers;
    }

}
