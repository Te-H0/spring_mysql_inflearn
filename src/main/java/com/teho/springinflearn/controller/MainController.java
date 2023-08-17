package com.teho.springinflearn.controller;

import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.dto.UserLoginForm;
import com.teho.springinflearn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/login")
    public String test(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return "redirect:/main";
        }
        model.addAttribute("user", new UserLoginForm());
        return "/html/login.html";
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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping("/errorPage")
    public String errorPage(HttpServletRequest request, Model model) {
        log.info("ERROR 페이지 접근.");
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

        return "/html/error.html";
    }

}
