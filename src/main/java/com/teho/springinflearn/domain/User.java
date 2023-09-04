package com.teho.springinflearn.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;

    @Column(name = "login_id", unique = true)
    @NotNull
    private String loginId;

    @NotNull
    private String pw;

    @NotNull
    private String email;

    @NotNull
    private Integer age;

    @NotNull
    private String address;

    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public User(String name, String login_id, String pw,
                String email, Integer age, String address) {
        this.name = name;
        this.loginId = login_id;
        this.pw = pw;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    protected User() {

    }
}
