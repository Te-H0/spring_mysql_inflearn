package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Enrollment;
import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnrollService {

    private final EnrollmentRepository enrollmentRepository;

    public void enrollNewCourse(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    public Enrollment checkDuplicatedEnroll(User user, Course course) {
        return enrollmentRepository.findByUserAndCourse(user, course);
    }

    public List<Enrollment> getEnrollsByUser(User user) {
        return enrollmentRepository.findByUser(user);
    }

    public Enrollment getEnrollById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    public boolean deleteEnrollById(Long id) {
        Enrollment enroll = enrollmentRepository.findById(id).orElse(null);
        if (enroll == null) {
            return false;
        }
        enrollmentRepository.delete(enroll);
        return true;
    }
}
