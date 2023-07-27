package com.teho.springinflearn;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Teacher;
import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.repository.CategoryRepository;
import com.teho.springinflearn.repository.CourseRepository;
import com.teho.springinflearn.repository.TeacherRepository;
import com.teho.springinflearn.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class InitData {
    private final CategoryRepository categoryRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void dataInit() {
        User user = new User("teho", "test", "test", "test", 24, "seoul");
        userRepository.save(user);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("spring"));
        categoryList.add(new Category("backend"));
        categoryList.add(new Category("c"));
        categoryList.add(new Category("css"));
        categoryList.add(new Category("figma"));
        categoryList.add(new Category("html"));
        categoryList.add(new Category("java"));
        categoryList.add(new Category("mvc"));
        categoryList.add((new Category("network")));
        categoryList.add((new Category("nodejs")));
        categoryList.add((new Category("python")));
        categoryList.add((new Category("springboot")));

        categoryRepository.saveAll(categoryList);

        List<Teacher> teacherList = new ArrayList<>();

        teacherList.add(new Teacher("김영한", "younghan@asd.com", 7));
        teacherList.add(new Teacher("널널한 개발자", "freedeveloper@qwer.com", 3));
        teacherList.add(new Teacher("토비", "tobi@naver.com", 1));
        teacherList.add(new Teacher("범쌤", "tiger@zxcv.com", 4));
        teacherList.add(new Teacher("코딩웍스", "codingworks@flsl.com", 2));
        teacherList.add(new Teacher("얄팍한 코딩사전", "zxcvaw@daum.net", 5));
        teacherList.add(new Teacher("조코딩", "jocoding@gmail.com", 2));
        teacherList.add(new Teacher("코드캠프", "codecamp@inu.ac.kr", 6));
        teacherList.add(new Teacher("김태원", "kim23422@asdf.com", 9));
        teacherList.add(new Teacher("인프런", "inflearn@inflearn.com", 12));

        teacherRepository.saveAll(teacherList);

        log.info("111111111111");
        Teacher kim = teacherRepository.findByName("김영한");
        Teacher inf = teacherRepository.findByName("인프런");
        Teacher free = teacherRepository.findByName("널널한 개발자");
        Teacher tobi = teacherRepository.findByName("토비");
        Teacher tiger = teacherRepository.findByName("범쌤");
        Teacher coding = teacherRepository.findByName("코딩웍스");
        Teacher dict = teacherRepository.findByName("얄팍한 코딩사전");
        Teacher jo = teacherRepository.findByName("조코딩");
        Teacher camp = teacherRepository.findByName("코드캠프");
        Teacher taewon = teacherRepository.findByName("김태원");
        log.info("222222222222222");
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
        log.info("3333333333333333");
        courseRepository.saveAll(courseList);

    }
}
