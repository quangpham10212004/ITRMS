package com.robin.itrms.controller;

import com.robin.itrms.eenum.RoleUser;
import com.robin.itrms.eenum.UserStatus;
import com.robin.itrms.entity.Admin;
import com.robin.itrms.entity.Member;
import com.robin.itrms.entity.User;
import com.robin.itrms.repository.MemberRepository;
import com.robin.itrms.repository.UserRepository;
import com.robin.itrms.service.AdminService;
import com.robin.itrms.service.MemberService;
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
	@Autowired
	private MemberService memberService;
	private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    @Autowired
    private UserRepository userRepository;
    public PageController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String LoginPage(){
        return "login";
    }

    @PostMapping("/register")
    public String RegisterMemberPage(@ModelAttribute User user, Model model){
        memberService.CreateNewMember(user);
        model.addAttribute("success","Successfully registered");
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String RegisterMemberPage(Model model){
        model.addAttribute("user", new Member());
        return "register-member";
    }

    @PostMapping("/register-admin")
    public String RegisterAdminPage(@ModelAttribute User user, Model model){
        adminService.CreateNewAdmin(user);
        model.addAttribute("success","Successfully registered");
        return "redirect:/login";
    }

    @GetMapping("/register-admin")
    public String RegisterAdminPage(Model model){
        model.addAttribute("user", new Admin());
        return "register-admin";
    }
}
