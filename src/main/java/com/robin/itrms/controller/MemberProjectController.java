package com.robin.itrms.controller;

import com.robin.itrms.entity.Member;
import com.robin.itrms.entity.MemberProject;
import com.robin.itrms.entity.Project;
import com.robin.itrms.entity.User;
import com.robin.itrms.service.MemberProjectService;
import com.robin.itrms.service.ProjectService;
import com.robin.itrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project-members")
public class MemberProjectController {

    @Autowired
    private MemberProjectService service;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @GetMapping("/{projectId}")
    public String ShowAllMemberProjects(Model model, @PathVariable Long projectId){
        Project p = projectService.getOneProject(projectId);
        model.addAttribute("mps", service.GetMPsByProject(p));
        return "members-in-project";
    }

    @GetMapping("/{projectId}/add")
    public String AddMemberProject(@PathVariable Long projectId, Model model){
        Project project = projectService.getOneProject(projectId);
        List<User> members = userService.getAllMembers();
        model.addAttribute("members", members);
        model.addAttribute("project", project);
    	return "add-member-to-project";
    }

    @PostMapping("/add")
    public String AddMemberProjectPost(@RequestParam Long memberId, @RequestParam Long projectId){
        service.AddMemberProject(memberId, projectId);
        return "redirect:/projects/" + projectId;
    }

    @PostMapping("/remove")
    public String RemoveMemberProject(@RequestParam Long mpId, @RequestParam Long projectId) {
        service.RemoveMemberProject(mpId);
        return "redirect:/projects/" + projectId;
    }
}
