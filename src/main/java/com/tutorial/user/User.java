package com.tutorial.user;

public class User {

    private Integer id;
    private String name;
    private String date_of_birth;

    public User( Integer id, String name, String date_of_birth) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    public User(String name, String date_of_birth){
        this.id = null;
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return date_of_birth;
    }
}
