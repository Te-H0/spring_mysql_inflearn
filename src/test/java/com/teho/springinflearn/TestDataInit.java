package com.teho.springinflearn;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Teacher;
import com.teho.springinflearn.repository.CategoryRepository;
import com.teho.springinflearn.repository.CourseRepository;
import com.teho.springinflearn.repository.TeacherRepository;
import com.teho.springinflearn.repository.UserRepository;
import com.teho.springinflearn.service.CourseService;
import com.teho.springinflearn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestDataInit {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Test
    @Transactional
    @Rollback(value = false)
    void mappingCategory() {
        Category spring = categoryRepository.findByName("spring");
        Category backend = categoryRepository.findByName("backend");
        Category c = categoryRepository.findByName("c");
        Category css = categoryRepository.findByName("css");
        Category figma = categoryRepository.findByName("figma");
        Category html = categoryRepository.findByName("html");
        Category java = categoryRepository.findByName("java");
        Category mvc = categoryRepository.findByName("mvc");
        Category network = categoryRepository.findByName("network");
        Category nodejs = categoryRepository.findByName("nodejs");
        Category python = categoryRepository.findByName("python");
        Category springboot = categoryRepository.findByName("springboot");

        courseRepository.findByTitle("스프링 핵심 원리 - 기본편").getCategoryList().add(spring);
        courseRepository.findByTitle("스프링 핵심 원리 - 기본편").getCategoryList().add(backend);
        courseRepository.findByTitle("스프링 핵심 원리 - 기본편").getCategoryList().add(mvc);
        courseRepository.findByTitle("스프링 핵심 원리 - 고급편").getCategoryList().add(spring);
        courseRepository.findByTitle("스프링 핵심 원리 - 고급편").getCategoryList().add(backend);
        courseRepository.findByTitle("스프링 핵심 원리 - 고급편").getCategoryList().add(mvc);
        courseRepository.findByTitle("스프링 부트 - 핵심 원리와 활용").getCategoryList().add(spring);
        courseRepository.findByTitle("스프링 부트 - 핵심 원리와 활용").getCategoryList().add(springboot);
        courseRepository.findByTitle("스프링 부트 - 핵심 원리와 활용").getCategoryList().add(backend);
        courseRepository.findByTitle("토비의 스프링 부트 - 이해와 원리").getCategoryList().add(springboot);
        courseRepository.findByTitle("토비의 스프링 부트 - 이해와 원리").getCategoryList().add(spring);
        courseRepository.findByTitle("토비의 스프링 부트 - 이해와 원리").getCategoryList().add(backend);
        courseRepository.findByTitle("외워서 끝내는 네트워크 핵심이론 - 기초").getCategoryList().add(network);
        courseRepository.findByTitle("외워서 끝내는 네트워크 핵심이론 - 응용").getCategoryList().add(network);
        courseRepository.findByTitle("모든 개발자를 위한 HTTP 웹 기본 지식").getCategoryList().add(network);
        courseRepository.findByTitle("독하게 되새기는 C 프로그래밍").getCategoryList().add(c);
        courseRepository.findByTitle("디자인 시스템 with 피그마").getCategoryList().add(figma);
        courseRepository.findByTitle("모바엘 웹 퍼블리싱 포트폴리오 with Figma").getCategoryList().add(figma);
        courseRepository.findByTitle("최고의 프론트엔드 CSS Frameworks, Uikit").getCategoryList().add(css);
        courseRepository.findByTitle("제대로 파는 HTML CSS - by 얄코").getCategoryList().add(html);
        courseRepository.findByTitle("제대로 파는 HTML CSS - by 얄코").getCategoryList().add(css);
        courseRepository.findByTitle("강력한 CSS").getCategoryList().add(css);
        courseRepository.findByTitle("부트캠프에서 만든 고농축 백엔드 코스").getCategoryList().add(backend);
        courseRepository.findByTitle("조코딩의 코딩 기초와 웹 풀스택 개발").getCategoryList().add(nodejs);
        courseRepository.findByTitle("조코딩의 코딩 기초와 웹 풀스택 개발").getCategoryList().add(html);
        courseRepository.findByTitle("조코딩의 코딩 기초와 웹 풀스택 개발").getCategoryList().add(nodejs);
        courseRepository.findByTitle("자바(JAVA) 알고리즘 문제풀이 입문: 코딩테스트 대비").getCategoryList().add(java);
        courseRepository.findByTitle("프로그래밍 시작하기 : 파이썬 입문 (Inflearn Original)").getCategoryList().add(python);
        courseRepository.findByTitle("우리를 위한 프로그래밍 : 파이썬 중급 (Inflearn Original)").getCategoryList().add(python);


    }
}
