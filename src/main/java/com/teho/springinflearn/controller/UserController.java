package com.teho.springinflearn.controller;

import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.dto.UserLoginForm;
import com.teho.springinflearn.dto.UserRegistForm;
import com.teho.springinflearn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/user/new")
    public String reigst() {
        return "/html/regist.html";
    }

    @PostMapping("/user/new")
    public String registUser(@ModelAttribute UserRegistForm userRegistForm) {
        userService.join(userRegistForm);
        return "redirect:/login";
    }

    @GetMapping("/user/list")
    public String showUsers(Model model) {
        List<User> users = userService.showUsers();
        model.addAttribute("users", users);
        return "/html/userList.html";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute UserLoginForm userLoginForm, HttpServletRequest request, Model model) {
        log.info("여기!!!!!");

        Optional<User> loginUser = Optional.ofNullable(userService.login(userLoginForm));
        if (loginUser.isPresent()) {
            User user = loginUser.get();

            log.info("loginuser 받았다");
            log.info("loginuser 정보 ==>{}", user.getName());
            HttpSession session = request.getSession();
            log.info("1");
            session.setAttribute("loginUser", user);
            log.info("2");
            session.setMaxInactiveInterval(30000);
            log.info("3");
            model.addAttribute("user", user);


            log.info("로그인 성공해서 메인페이지 이동중");
            return "redirect:/main";

        } else {
            log.info("User Null이여서 다시 로그인 페이지!");
            return "/html/login.html";
        }


    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }


}
