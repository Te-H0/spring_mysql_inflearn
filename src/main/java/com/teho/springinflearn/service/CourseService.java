package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Teacher;
import com.teho.springinflearn.repository.CategoryRepository;
import com.teho.springinflearn.repository.CourseRepository;
import com.teho.springinflearn.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final TeacherRepository teacherRepository;

    public Course getCourseById(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        return courseOptional.orElse(null);
    }

    public List<Course> showAllCourse() {

        return courseRepository.findAll();
    }

    public List<Course> findCoursesByCategory(String category) {
        Category nowCategory = categoryRepository.findByName(category);
        return courseRepository.findAllByCategoryList(nowCategory);

    }

    public List<Course> showCoursesByKeyword(String keyword) {
        List<Course> courseList = new ArrayList<>();

        courseList.addAll(courseRepository.findAllByTitleContaining(keyword));

        List<Teacher> teachersByName = teacherRepository.findAllByNameContaining(keyword);
        for (Teacher teacher : teachersByName) {
            courseList.addAll(courseRepository.findAllByTeacher(teacher));
        }

        List<Category> categoriesByName = categoryRepository.findAllByNameContaining(keyword);
        for (Category category : categoriesByName) {
            courseList.addAll(courseRepository.findAllByCategoryList(category));
        }

        return courseList;

    }

}
