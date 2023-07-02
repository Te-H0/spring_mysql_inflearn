package com.teho.springinflearn.domain;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long id;

    @Email(message = "이메일 형태를 적어주세요~!")
    @NotNull
    private String email;

    @NotNull
    private int career;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courseList = new ArrayList<>();
}
/**
 * CREATE TABLE Teacher(
 * teacher_id INT AUTO_INCREMENT PRIMARY KEY,
 * name VARCHAR(60) NOT NULL,
 * email VARCHAR(60) NOT NULL,
 * career INT NOT NULL
 * );
 */