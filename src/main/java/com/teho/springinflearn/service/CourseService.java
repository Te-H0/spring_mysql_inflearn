package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> showAllCourse() {

        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
}
