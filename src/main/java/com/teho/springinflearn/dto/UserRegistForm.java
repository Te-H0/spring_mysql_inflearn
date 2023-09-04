package com.teho.springinflearn.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class UserRegistForm {

    @NotBlank
    private String name;

    @NotBlank
    private String login_id;

    @NotBlank
    private String pw;

    @NotBlank
    private String email;

    @NotNull
    @Range(min = 1, max = 150)
    private Integer age;

    @NotBlank
    private String address;

}
