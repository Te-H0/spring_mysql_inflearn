package com.teho.springinflearn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginForm {
    @NotBlank
    private String login_id;

    @NotBlank
    private String pw;
    

}
