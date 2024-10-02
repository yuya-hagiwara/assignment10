package com.tutorial.user;

public class User {

    private int id;
    private String name;
    private String date_of_birth;

    public User(int id, String name, String date_of_birth) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }
}


