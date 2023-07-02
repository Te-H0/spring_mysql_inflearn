package com.teho.springinflearn.controller;

import com.teho.springinflearn.domain.User;
import com.teho.springinflearn.dto.UserRegistDTO;
import com.teho.springinflearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TempController {

    private final UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "/html/login.html";
    }

    @RequestMapping("/main")
    public String main() {
        return "/html/main.html";
    }

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
}
