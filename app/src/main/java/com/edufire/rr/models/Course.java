package com.edufire.rr.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private final String name;
    private  Professor professor;
    private final ArrayList<Student> students;
    private static HashMap<String, Course> classes = new HashMap<>() ;
    private HashMap<String,Exercise> exercisesOfClass=new HashMap<>();

    private static Course activeCourse;

    public Course(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
        students = new ArrayList<>();
        if(classes==null){
            classes=new HashMap<>();
        }
        professor.addNewClass(name);///here should call on object(I fixed it)
        classes.put(name,this);
    }

    public static void setActiveCourseByName(String activeCourseName) {
        Course.activeCourse = classes.get(activeCourseName);
    }

    public static Course getActiveCourse() {
        return activeCourse;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public static HashMap<String, Course> getClasses() {
        return classes;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getName() {
        return name;
    }

    public void addExerciseToClass(Exercise exercise){
        if (exercisesOfClass ==null){
            exercisesOfClass=new HashMap<>();
        }
        exercisesOfClass.put(exercise.getNameOfExercise(),exercise);
    }

    public static ArrayList<Course> getCoursesArrayList(){
        return new ArrayList<>(classes.values());
    }

    public static Course getCourseByName(String name){
        return classes.get(name);
    }
    public static void setClasses(HashMap<String, Course> classes) {
        Course.classes = classes;
    }
    public ArrayList<Exercise> getExercisesArrayList(){
        ArrayList<Exercise> exercises = new ArrayList<>(exercisesOfClass.values());
        return exercises;
    }

}
