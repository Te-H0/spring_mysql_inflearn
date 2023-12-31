package com.teho.springinflearn.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @ManyToMany
    @JoinTable(name = "COURSE_CATEGORY",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categoryList = new HashSet<>();

    public Course(Teacher teacher, String title, int price, int discount) {
        this.teacher = teacher;
        this.title = title;
        this.price = price;
        this.discount = discount;
    }

    protected Course() {

    }
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