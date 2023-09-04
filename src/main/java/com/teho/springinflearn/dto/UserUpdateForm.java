package com.teho.springinflearn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateForm {

    @NotBlank
    private String name;

    @NotBlank
    private String login_id;

    @NotBlank
    private String pw;

    @NotBlank
    private String email;

    @NotBlank
    private String address;

}
