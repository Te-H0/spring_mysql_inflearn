package com.teho.springinflearn.controller;

import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.dto.UserLoginDTO;
import com.teho.springinflearn.dto.UserRegistDTO;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public String registUser(@ModelAttribute UserRegistDTO userRegistDTO) {
        userService.join(userRegistDTO);
        return "redirect:/login";
    }

    @GetMapping("/user/list")
    public String showUsers(Model model) {
        List<User> users = userService.showUsers();
        model.addAttribute("users", users);
        return "/html/userList.html";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute UserLoginDTO userLoginDTO, HttpServletRequest request,
                            RedirectAttributes redirectAttributes) {
        log.info("여기!!!!!");
        UserLoginDTO loginUser = userService.login(userLoginDTO);
        log.info("login서비스에서 반환된 user 값 {}", loginUser.getName());
        if (loginUser != null) {
            log.info("loginuser 받았다");
            log.info("loginuser 정보 ==>{}", loginUser.getName());
            HttpSession session = request.getSession();
            log.info("1");
            session.setAttribute("loginUser", loginUser);
            log.info("2");
            session.setMaxInactiveInterval(30000);
            log.info("3");
            redirectAttributes.addAttribute("loginUser", loginUser.getName());
            log.info("4");
        }
        log.info("5");
        return "redirect:/login";
    }


}
