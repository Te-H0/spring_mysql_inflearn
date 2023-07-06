package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
