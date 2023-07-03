package com.teho.springinflearn.dto;

import lombok.Getter;

@Getter
public class UserRegistDTO {

    private String name;
    private String login_id;
    private String pw;
    private String email;
    private int age;
    private String address;

    public UserRegistDTO(String name, String login_id, String pw,
                         String email, int age, String address) {
        this.name = name;
        this.login_id = login_id;
        this.pw = pw;
        this.email = email;
        this.age = age;
        this.address = address;
    }


}
