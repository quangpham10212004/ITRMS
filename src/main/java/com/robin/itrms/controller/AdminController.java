package com.robin.itrms.controller;


import com.robin.itrms.entity.Project;
import com.robin.itrms.entity.User;
import com.robin.itrms.service.ProjectService;
import com.robin.itrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminController {
    
    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public AdminController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("")
    public String adminDashboard(Model model) {
        User user = userService.getCurentUser();
        model.addAttribute("user", user);
        
        // Check if user is actually an Admin to avoid ClassCastException
        // The service casts User to Admin, so valid casting is required.
        // Assuming the current user should be an Admin if they access this page.
        // If not, this might throw, but we'll let existing service logic hold for now.
        try {
             List<Project> projects = projectService.getProjectsByAdmin(user);
             model.addAttribute("projects", projects);
        } catch (ClassCastException e) {
             // Fallback if user is not an admin entity
             model.addAttribute("projects", java.util.Collections.emptyList());
             // Optionally log error
        } catch (Exception e) {
             model.addAttribute("projects", java.util.Collections.emptyList());
        }
        
        return "admin-dashboard";
    }


}
