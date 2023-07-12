package com.teho.springinflearn.dto;

import lombok.Getter;

@Getter
public class UserUpdateForm {


    private String name;
    private String login_id;
    private String pw;
    private String email;
    private String address;

    public UserUpdateForm(String name, String login_id, String pw,
                          String email, String address) {
        this.name = name;
        this.login_id = login_id;
        this.pw = pw;
        this.email = email;
        this.address = address;
    }
}
