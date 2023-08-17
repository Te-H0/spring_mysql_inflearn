package com.teho.springinflearn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateForm {


    private String name;
    private String login_id;
    private String pw;
    private String email;
    private String address;

}
