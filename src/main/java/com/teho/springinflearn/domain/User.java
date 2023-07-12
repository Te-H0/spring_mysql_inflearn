package com.teho.springinflearn.domain;

import jakarta.persistence.*;
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

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public User(String name, String login_id, String pw,
                String email, int age, String address) {
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
