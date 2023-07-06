package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Teacher;
import com.teho.springinflearn.repository.CategoryRepository;
import com.teho.springinflearn.repository.CourseRepository;
import com.teho.springinflearn.repository.TeacherRepository;
import com.teho.springinflearn.service.CourseService;
import com.teho.springinflearn.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class TestDataInit {
    private final CourseService courseService;
    private final UserService userService;
    private final CategoryRepository categoryRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @PostConstruct
    public void init() {
////        Category category = new Category("spring");
////        categoryRepository.save(category);
////        log.info("category save");
//        Teacher teacher = new Teacher("김영한", "younghan@asdf.com", 7);
//        Course course = new Course(teacher, "스프링 입문 - 코드로 배우는 스프링 부트,웹 MVC,DB 접근기술", 30000, 0);
////        course.setCategory(category);
//        log.info("category save");
//        courseRepository.save(course);

//        Category spring = categoryRepository.findByName("spring");
//
//        Course byId = courseService.findById(1L);
//        if (byId != null) {
//
//            byId.setPrice(133334);
//
//            log.info("가격바꿈");
//        }
    }
}
