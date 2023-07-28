package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Teacher;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByCategoryList(Category category);

    Course findByTitle(String title);

    List<Course> findAllByTitleContaining(String keyword);

    List<Course> findAllByTeacher(Teacher teacher);


}
