package com.edufire.rr.models;

import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String completeName;


    private static HashMap<String, User> users;
    private boolean isStudent;

    static {
        users = new HashMap<>();
    }

    public User(String username, String password, String completeName, boolean isStudent) {
        this.username = username;
        this.password = password;
        this.completeName = completeName;
        this.isStudent = isStudent;
        users.put(username, this);
    }


    public static void setUsers(HashMap<String,User> newUsers){
        users=newUsers;
    }


    public static HashMap<String, User> getUsers() {
        return users;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCompleteName() {
        return completeName;
    }

    public static boolean doesTheUserExist(String username) {
        return users.get(username) != null;
    }

    public static User getUser(String username) {
        return users.get(username);
    }

    public boolean isStudent() {
        return isStudent;
    }
}
