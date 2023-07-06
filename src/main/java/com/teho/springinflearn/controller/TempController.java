package com.teho.springinflearn.controller;

import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.service.CourseService;
import com.teho.springinflearn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TempController {

    private final CourseService courseService;

    @GetMapping("/login")
    public String test(@RequestParam(required = false) String loginUser, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return "redirect:/main";
        }
        return "/html/login.html";
    }

    @RequestMapping("/main")
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

    @RequestMapping("/course")
    public String showCourse(@RequestParam String keyword, Model model) {
        if (keyword.equals("all")) {
            List<Course> courseList = courseService.showAllCourse();
            model.addAttribute("courses", courseList);
        }
        return "/html/course.html";
    }


}
