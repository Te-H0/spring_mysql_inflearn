package com.teho.springinflearn.controller;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Enrollment;
import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.repository.CategoryRepository;
import com.teho.springinflearn.repository.CourseRepository;
import com.teho.springinflearn.repository.EnrollmentRepository;
import com.teho.springinflearn.service.CourseService;
import com.teho.springinflearn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TempController {

    private final CourseService courseService;
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final EnrollmentRepository enrollmentRepository;

    @GetMapping("/login")
    public String test(@RequestParam(required = false) String loginUser, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return "redirect:/main";
        }
        return "/html/login.html";
    }

    @GetMapping("/main")
    public String main(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "/html/login.html";
        }
        log.info("user의 이름 입력전!!!!!!!!!!!!!!!!!! 로그인 성공해서 메인페이지 이동중");

        model.addAttribute("user", loginUser);
        log.info("user의 이름 {}", loginUser.getName());
        return "/html/main.html";
    }

    @GetMapping("/course")
    public String showCourse(@RequestParam String keyword, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "/html/login.html";
        }

        model.addAttribute("user", loginUser);
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);

        List<Course> courseList;
        if (keyword.equals("all")) {
            courseList = courseService.showAllCourse();

        } else {
            courseList = courseService.findCoursesByCategory(keyword);
        }
        model.addAttribute("courses", courseList);


        return "/html/course.html";
    }

    @PostMapping("/enroll")
    public String enroll(@RequestParam Long courseId, @RequestParam double price, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "/html/login.html";
        }
        Course course = courseRepository.findById(courseId).get();
        Enrollment enrollment = enrollmentRepository.findByUserAndCourse(loginUser, course);

        String message = course.getTitle();

        if (enrollment == null) {
            Enrollment newEnroll = new Enrollment(loginUser, course);
            newEnroll.setPrice((int) price);
            enrollmentRepository.save(newEnroll);
            message += " 수강 신청 되었습니다!";
        } else {
            message += " 이미 신청한 강좌 입니다!";
        }

        redirectAttributes.addAttribute("message", message);

        return "redirect:/course/enrollResult";

    }

    @GetMapping("/course/enrollResult")
    public String enrollResult(@RequestParam String message, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "/html/login.html";
        }
        model.addAttribute("user", loginUser);
        model.addAttribute("message", message);
        return "/html/enrollResult";
    }

    @GetMapping("/myinfo")
    public String info(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        User loginUser = (User) session.getAttribute("loginUser");
        model.addAttribute("user", loginUser);
        return "/html/myinfo.html";
    }


}
