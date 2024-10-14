package com.tutorial.user;


public class UserRequest {
    private String name;

    public String dateOfBirth;

    public UserRequest(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
