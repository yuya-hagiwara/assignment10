package com.tutorial.user;

public class User {
    private Integer id;
    private String name;
    private String dateOfBirth;

    public User(Integer id, String name, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String name, String dateOfBirth) {
        this.id = null;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void updateUser(String name, String dateOfBirth) {
    }
}
