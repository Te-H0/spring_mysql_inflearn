package com.teho.springinflearn.service;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Teacher;
import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.repository.CategoryRepository;
import com.teho.springinflearn.repository.CourseRepository;
import com.teho.springinflearn.repository.TeacherRepository;
import com.teho.springinflearn.repository.UserRepository;
import groovy.util.logging.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CourseServiceTest {

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
    void test1() {
        Category java = categoryRepository.findByName("java2");
        java.setName("java");

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void test2() {
        Category spring = categoryRepository.findById(1L).get();
        Category backend = categoryRepository.findById(9L).get();
        Category c = categoryRepository.findById(12L).get();
        Category css = categoryRepository.findById(15L).get();
        Category figma = categoryRepository.findById(13L).get();
        Category html = categoryRepository.findById(14L).get();
        Category java = categoryRepository.findById(7L).get();
        Category mvc = categoryRepository.findById(8L).get();
        Category network = categoryRepository.findById(11L).get();
        Category nodejs = categoryRepository.findById(16L).get();
        Category python = categoryRepository.findById(17L).get();
        Category springboot = categoryRepository.findById(10L).get();

        Teacher kim = teacherRepository.findByName("김영한");
        Teacher inf = teacherRepository.findById(2L).get();
        Teacher free = teacherRepository.findById(3L).get();
        Teacher tobi = teacherRepository.findById(4L).get();
        Teacher tiger = teacherRepository.findById(5L).get();
        Teacher coding = teacherRepository.findById(6L).get();
        Teacher dict = teacherRepository.findById(7L).get();
        Teacher jo = teacherRepository.findById(8L).get();
        Teacher camp = teacherRepository.findById(9L).get();
        Teacher taewon = teacherRepository.findById(10L).get();

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(kim, "스프링 핵심 원리 - 기본편", 88000, 25));
        courseList.add(new Course(kim, "스프링 핵심 원리 - 고급편", 121000, 25));
        courseList.add(new Course(kim, "스프링 부트 - 핵심 원리와 활용", 99000, 25));
        courseList.add(new Course(kim, "모든 개발자를 위한 HTTP 웹 기본 지식", 44000, 25));
        courseList.add(new Course(free, "외워서 끝내는 네트워크 핵심이론 - 기초", 77000, 0));
        courseList.add(new Course(free, "외워서 끝내는 네트워크 핵심이론 - 응용", 66000, 0));
        courseList.add(new Course(free, "독하게 되새기는 C 프로그래밍", 110000, 0));
        courseList.add(new Course(tobi, "토비의 스프링 부트 - 이해와 원리", 99000, 0));
        courseList.add(new Course(tiger, "디자인 시스템 with 피그마", 44000, 0));
        courseList.add(new Course(coding, "모바엘 웹 퍼블리싱 포트폴리오 with Figma", 105600, 0));
        courseList.add(new Course(coding, "최고의 프론트엔드 CSS Frameworks, Uikit", 49500, 0));
        courseList.add(new Course(dict, "제대로 파는 HTML CSS - by 얄코", 44000, 25));
        courseList.add(new Course(jo, "조코딩의 코딩 기초와 웹 풀스택 개발", 90200, 0));
        courseList.add(new Course(camp, "부트캠프에서 만든 고농축 백엔드 코스", 396000, 0));
        courseList.add(new Course(camp, "강력한 CSS", 22000, 0));
        courseList.add(new Course(taewon, "자바(JAVA) 알고리즘 문제풀이 입문: 코딩테스트 대비", 77000, 0));
        courseList.add(new Course(inf, "프로그래밍 시작하기 : 파이썬 입문 (Inflearn Original)", 33000, 0));
        courseList.add(new Course(inf, "우리를 위한 프로그래밍 : 파이썬 중급 (Inflearn Original)", 55000, 0));

        courseRepository.saveAll(courseList);
     
    }
}