package com.teho.springinflearn.repository;

import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Enrollment;
import com.teho.springinflearn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    public Enrollment findByUserAndCourse(User user, Course course);

    public List<Enrollment> findByUser(User user);
}
