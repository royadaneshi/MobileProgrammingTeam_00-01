package com.edufire.rr;

import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String completeName;
    private static HashMap<String, User> users;
    private boolean isStudent;
    public static boolean isUserExist=false;
    static {
        users = new HashMap<>();
    }
    public User(String username, String password,String completeName,boolean isStudent) {
        if (users.containsKey(username)) {
            isUserExist=true;
        } else {
            this.username = username;
            this.password = password;
            this.completeName= completeName;
            this.isStudent=isStudent;
            users.put(username, this);
            isUserExist=false;
        }
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
    public static boolean doesTheUserExist(String username){
        return users.get(username) != null;
    }
    public static User getUser(String username) {
        return users.get(username);
    }

    public boolean isStudent() {
        return isStudent;
    }
}
