package com.robin.itrms.controller;

import com.robin.itrms.entity.User;
import com.robin.itrms.repository.UserRepository;
import com.robin.itrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private UserRepository userRepository;
    public PageController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String LoginPage(){
        return "login";
    }



    @GetMapping("/member/home")
    public String MemberPage(){
        return "member-home";
    }

    @PostMapping("/register")
    public String RegisterMemberPage(@ModelAttribute User user, Model model){
        user.setRole("MEMBER");
        user.setStatus("ACTIVE");
        model.addAttribute("success","Successfully registered");
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String RegisterMemberPage(Model model){
        // can dong nay de bind object do co dependency thymleaf
        model.addAttribute("user", new User());
        return "register-member";
    }
}
