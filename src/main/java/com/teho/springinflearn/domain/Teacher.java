package com.teho.springinflearn.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;

    @NotNull
    private String name;
    @Email(message = "이메일 형태를 적어주세요~!")
    @NotNull
    private String email;

    @NotNull
    private int career;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courseList = new ArrayList<>();

    protected Teacher() {
    }

    public Teacher(String name, String email, int career) {
        this.name = name;
        this.email = email;
        this.career = career;
    }
}
/**
 * CREATE TABLE Teacher(
 * teacher_id INT AUTO_INCREMENT PRIMARY KEY,
 * name VARCHAR(60) NOT NULL,
 * email VARCHAR(60) NOT NULL,
 * career INT NOT NULL
 * );
 */