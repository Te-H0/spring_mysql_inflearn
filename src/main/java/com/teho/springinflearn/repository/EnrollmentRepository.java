package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Enrollment;
import com.teho.springinflearn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    public Enrollment findByUserAndCourse(User user, Course course);
}
