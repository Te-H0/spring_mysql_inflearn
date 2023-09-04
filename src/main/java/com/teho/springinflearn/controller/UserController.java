package com.teho.springinflearn.controller;

import com.teho.springinflearn.domain.Enrollment;
import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.dto.UserLoginForm;
import com.teho.springinflearn.dto.UserRegistForm;
import com.teho.springinflearn.dto.UserUpdateForm;
import com.teho.springinflearn.service.EnrollService;
import com.teho.springinflearn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final EnrollService enrollService;

    @GetMapping("/new")
    public String reigst(Model model) {
        model.addAttribute("user", new UserRegistForm());
        return "/html/regist.html";
    }

    @PostMapping("/new")
    public String registUser(@Validated @ModelAttribute("user") UserRegistForm userRegistForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            log.info("error = {}", bindingResult);
            return "/html/regist.html";
        }

        userService.join(userRegistForm);
        return "redirect:/login";
    }

    @GetMapping("/list")
    public String showUsers(Model model) {
        List<User> users = userService.showUsers();
        model.addAttribute("users", users);
        return "/html/userList.html";
    }

    @GetMapping("/myMenu")
    public String info(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        User loginUser = (User) session.getAttribute("loginUser");
        model.addAttribute("user", loginUser);
        return "/html/myinfo.html";
    }

    @GetMapping("/profile")
    public String editProfile(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        log.info("1");

        if (session == null) {
            return "redirect:/login";
        }
        log.info("2");

        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "/html/login.html";
        }
        UserUpdateForm userUpdateForm = new UserUpdateForm();
        userUpdateForm.setName(loginUser.getName());
        userUpdateForm.setLogin_id(loginUser.getLoginId());
        userUpdateForm.setPw(loginUser.getPw());
        userUpdateForm.setAddress(loginUser.getAddress());
        userUpdateForm.setEmail(loginUser.getEmail());

        log.info("3");

        model.addAttribute("user", userUpdateForm);
        log.info("4");

        return "/html/editProfile.html";
    }

    @PostMapping("/profile")
    public String updateProfile(HttpServletRequest request, @Validated @ModelAttribute("user") UserUpdateForm user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("error = {}", bindingResult);
            return "/html/editProfile.html";
        }
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User loginUser = (User) session.getAttribute("loginUser");
        User nowUser = userService.getUserById(loginUser.getId());
        if (nowUser == null)
            return "redirect:/errorPage";

        log.info("update할 유저의 정보 {}", loginUser.getId());

        User updatedUser = userService.updateUser(user, nowUser);

        session.setAttribute("loginUser", updatedUser);
        return "redirect:/user/myMenu";
    }

    @GetMapping("/courses")
    public String myCourse(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "/html/login.html";
        }
        model.addAttribute("user", loginUser);

        List<Enrollment> enrollList = enrollService.getEnrollsByUser(loginUser);
        model.addAttribute("enrollments", enrollList);
        return "/html/myCourse.html";
    }

    @PostMapping("/courses")
    public String cancelCourse(@RequestParam Long enrollId, HttpServletRequest request, Model model) {
        Enrollment enroll = enrollService.getEnrollById(enrollId);
        if (enroll == null)
            return "redirect:/errorPage";

        boolean deleteResult = enrollService.deleteEnrollById(enrollId);

        if (!deleteResult)
            return "redirect:/errorPage";
        else
            return "redirect:/user/courses";
    }
}
