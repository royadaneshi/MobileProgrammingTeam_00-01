package com.edufire.rr;

import android.content.Context;
import android.content.SharedPreferences;

import com.edufire.rr.models.Course;
import com.edufire.rr.models.Professor;
import com.edufire.rr.models.Student;
import com.edufire.rr.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class DataBase {


    public static String convertUserHashMapToString(HashMap<String, User> hashMap) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(hashMap);
        return jsonString;
    }

    public static String convertStudentHashMapToString(HashMap<String, Student> hashMap) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(hashMap);
        return jsonString;
    }

    public static String convertProfessorHashMapToString(HashMap<String, Professor> hashMap) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(hashMap);
        return jsonString;
    }

    public static String convertCourseHashMapToString(HashMap<String, Course> hashMap) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(hashMap);
        return jsonString;
    }


    public static HashMap<String, User> convertStringToUserHashMap(String jsonString) {
        try {
            HashMap<String, User> userInfo;
            userInfo = new Gson().fromJson(jsonString,
                    new TypeToken<HashMap<String, User>>() {
                    }.getType());
            return userInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String, Student> convertStringToStudentHashMap(String jsonString) {
        try {
            HashMap<String, Student> studentInfo;
            studentInfo = new Gson().fromJson(jsonString,
                    new TypeToken<HashMap<String, Student>>() {
                    }.getType());
            return studentInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String, Professor> convertStringToProfessorHashMap(String jsonString) {
        try {
            HashMap<String, Professor> professorInfo;
            professorInfo = new Gson().fromJson(jsonString,
                    new TypeToken<HashMap<String, Professor>>() {
                    }.getType());
            return professorInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static HashMap<String, Course> convertStringToCourseHashMap(String jsonString) {
        try {
            HashMap<String, Course> courseInfo;
            courseInfo = new Gson().fromJson(jsonString,
                    new TypeToken<HashMap<String, Course>>() {
                    }.getType());
            return courseInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setPrefs(String key, String value, Context context, String name) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getPrefs(String key, Context context, String name) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedpreferences.getString(key, "notfound");
    }

}
