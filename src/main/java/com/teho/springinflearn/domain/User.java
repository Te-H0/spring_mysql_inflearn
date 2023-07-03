package com.teho.springinflearn.domain;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;

    @Column(unique = true)
    @NotNull
    private String login_id;

    @NotNull
    private String pw;

    @NotNull
    private String email;

    @NotNull

    private int age;

    @NotNull
    private String address;

    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public User(String name, String login_id, String pw,
                String email, int age, String address) {
        this.name = name;
        this.login_id = login_id;
        this.pw = pw;
        this.email = email;
        this.age = age;
        this.address = address;
    }
}
/**
 * CREATE TABLE User(
 * user_id INT AUTO_INCREMENT PRIMARY KEY,
 * name VARCHAR(20) NOT NULL UNIQUE,
 * email VARCHAR(60) NOT NULL,
 * age INT NOT NULL,
 * address VARCHAR(60) NOT NULL,
 * login BOOLEAN DEFAULT 0
 * );
 */