package com.teho.springinflearn.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserLoginDTO {
    private String login_id;
    private String pw;
    private String name;

    public UserLoginDTO(String login_id, String pw, String name) {
        this.login_id = login_id;
        this.pw = pw;
        this.name = name;
    }
}
