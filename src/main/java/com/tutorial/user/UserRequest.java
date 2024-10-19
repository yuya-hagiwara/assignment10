package com.tutorial.user;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {

    @NotBlank(message = "氏名を入力してください")
    @Size(max = 20, message = "名前は{max}文字以内で入力してください")
    private String name;

    @NotBlank(message = "生年月日を入力ください")
    private String dateOfBirth;

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
