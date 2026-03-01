package com.robin.itrms.controller;

import com.robin.itrms.entity.Member;
import com.robin.itrms.entity.MemberProject;
import com.robin.itrms.entity.User;
import com.robin.itrms.service.MemberProjectService;
import com.robin.itrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private UserService userService;
    @Autowired
    private MemberProjectService memberProjectService;

    @GetMapping("/dashboard")
    public String memberDashboard(Model model) {
        User user = userService.getCurentUser();
        if (user instanceof Member) {
            Member member = (Member) user;
            List<MemberProject> assignment = member.getMemberProjects();
            model.addAttribute("assignments", assignment);
        }
        model.addAttribute("user", user);
        return "member-dashboard";
    }

    @GetMapping("/projects/{assignmentId}")
    public String viewProjectTasks(@PathVariable Long assignmentId, Model model) {
        MemberProject assignment = memberProjectService.GetOneMP(assignmentId);
        model.addAttribute("assignment", assignment);
        return "member-project-detail";
    }
}
