package com.teho.springinflearn.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "categoryList")
    private Set<Course> courseList = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }

    protected Category() {
    }
}
