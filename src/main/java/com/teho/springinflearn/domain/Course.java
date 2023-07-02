package com.teho.springinflearn.domain;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @NotNull
    private String title;

    @NotNull
    @Min(0)
    private int price;

    @ColumnDefault("0")
    @Min(0)
    @Max(100)
    private int discount;

    @ManyToMany(mappedBy = "courseList")
    private List<Category> categoryList = new ArrayList<>();
}


/**
 * course_id INT  AUTO_INCREMENT PRIMARY KEY,
 * teacher_id INT NOT NULL,
 * title VARCHAR(255) NOT NULL,
 * category VARCHAR(255),
 * price INT NOT NULL,
 * discount INT DEFAULT 0 CHECK(discount >= 0 AND discount < 100),
 * FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id) ON DELETE CASCADE ON UPDATE CASCADE
 */