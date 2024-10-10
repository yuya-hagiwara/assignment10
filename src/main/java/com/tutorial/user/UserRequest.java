package com.tutorial.user;


public class UserRequest {
    private String name;

    public String date_of_birth;

    public UserRequest(String name, String date_of_birth) {
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return date_of_birth;
    }
}
