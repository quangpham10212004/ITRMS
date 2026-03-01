package com.robin.itrms.controller;

import com.robin.itrms.entity.MemberProject;
import com.robin.itrms.entity.Project;
import com.robin.itrms.entity.Task;
import com.robin.itrms.service.MemberProjectService;
import com.robin.itrms.service.ProjectService;
import com.robin.itrms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private MemberProjectService memberProjectService;

    @GetMapping("/create")
    public String ShowCreateTaskForm(@RequestParam Long projectId, Model model) {
        Project project = projectService.getOneProject(projectId);
        List<MemberProject> mps = memberProjectService.GetMPsByProject(project);
        
        model.addAttribute("project", project);
        model.addAttribute("mps", mps);
        model.addAttribute("task", new Task());
        return "create-task";
    }

    @PostMapping("/create")
    public String CreateTask(@ModelAttribute Task task, @RequestParam Long mpId, @RequestParam Long projectId) {
        MemberProject mp = new MemberProject();
        mp.setId(mpId);
        task.setMemberProject(mp);
        task.setTaskStatus("TODO"); // Default status
        taskService.CreateOne(task);
        return "redirect:/projects/" + projectId;
    }
}
