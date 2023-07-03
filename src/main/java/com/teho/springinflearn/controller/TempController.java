package com.teho.springinflearn.controller;

import com.teho.springinflearn.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TempController {

    private final UserService userService;

    @GetMapping("/login")
    public String test(@RequestParam(required = false) String loginUser, Model model) {
        if (loginUser != null)
            model.addAttribute("loginUser", loginUser);

        log.info("컨트롤러에서 받은 유저 이름{}", loginUser);
        return "/html/login.html";
    }

    @RequestMapping("/main")
    public String main() {
        return "/html/main.html";
    }


}
