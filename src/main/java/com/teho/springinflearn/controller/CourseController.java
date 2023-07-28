package com.teho.springinflearn.controller;

import com.teho.springinflearn.domain.Category;
import com.teho.springinflearn.domain.Course;
import com.teho.springinflearn.domain.Enrollment;
import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.repository.CategoryRepository;
import com.teho.springinflearn.service.CourseService;
import com.teho.springinflearn.service.EnrollService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final EnrollService enrollService;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String showCourse(@RequestParam(defaultValue = "all") String keyword, Model model, HttpServletRequest request) {
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
        log.info("course keyword ={}", keyword);
        if (keyword.equals("all")) {
            courseList = courseService.showAllCourse();

        } else {
            courseList = courseService.showCoursesByKeyword(keyword);
        }
        for (Course course : courseList) {
            int price = course.getPrice();
            int discount = course.getDiscount();
            course.setPrice((int) (price * (1 - discount * 0.01)));
//            course.price * ( 1 -course.discount * 0.01 )
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
        Course course = courseService.getCourseById(courseId);
        if (course == null)
            return "redirect:/errorPage";

        Enrollment enrollment = enrollService.checkDuplicatedEnroll(loginUser, course);

        String message = course.getTitle();

        if (enrollment == null) {
            Enrollment newEnroll = new Enrollment(loginUser, course);
            newEnroll.setPrice((int) price);
            enrollService.enrollNewCourse(newEnroll);
            message += " 수강 신청 되었습니다!";
        } else {
            message += " 이미 신청한 강좌 입니다!";
        }

        redirectAttributes.addAttribute("message", message);

        return "redirect:/course/enrollResult";
    }

    @GetMapping("/enrollResult")
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
}


