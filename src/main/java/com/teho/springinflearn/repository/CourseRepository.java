package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findAllByCategory(Category category);

    public Course findByTitle(String title);
}
