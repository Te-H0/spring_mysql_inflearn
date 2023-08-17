package com.teho.springinflearn.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginForm {
    private String login_id;
    private String pw;
    private String name;

}
