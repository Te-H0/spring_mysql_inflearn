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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public String main(@SessionAttribute(name = "loginUser", required = false) User loginUser, Model model,
                       @ModelAttribute(name = "user") UserLoginForm userLoginForm, HttpServletRequest request) {
        if (loginUser != null) {
            model.addAttribute("user", loginUser);
            return "/html/main.html";
        }
        return "/html/login.html";
    }

    @PostMapping("/")
    public String loginUser(@Validated @ModelAttribute("user") UserLoginForm userLoginForm, BindingResult bindingResult, HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("error = {}", bindingResult);
            return "/html/login.html";
        }


        Optional<User> loginUser = Optional.ofNullable(userService.login(userLoginForm));
        if (loginUser.isPresent()) {
            User user = loginUser.get();

            log.info("loginuser 받았다");
            log.info("loginuser 정보 ==>{}", user.getName());
            HttpSession session = request.getSession();
            log.info("1");
            session.setAttribute("loginUser", user);
            log.info("2");
            model.addAttribute("user", user);


            log.info("로그인 성공해서 메인페이지 이동중");
            return "redirect:/";

        } else {
            bindingResult.reject("wrongUserInfo", "유저 정보를 다시 확인해라");
            log.info("bindingresult in login =>{}", bindingResult);
            log.info("User Null이여서 다시 로그인 페이지!");
            return "/html/login.html";
        }

    }

//    @GetMapping("/main")
//    public String main(HttpServletRequest request, Model model) {
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return "redirect:/login";
//        }
//        User loginUser = (User) session.getAttribute("loginUser");
//
//        if (loginUser == null) {
//            return "/html/login.html";
//        }
//        log.info("user의 이름 입력전!!!!!!!!!!!!!!!!!! 로그인 성공해서 메인페이지 이동중");
//
//        model.addAttribute("user", loginUser);
//        log.info("user의 이름 {}", loginUser.getName());
//        return "/html/main.html";
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
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
