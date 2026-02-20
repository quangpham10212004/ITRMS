package com.robin.itrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.robin.itrms.entity.Project;
import com.robin.itrms.service.ProjectService;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping("")
	public String showAllProjects(Model model){
		model.addAttribute("projects", projectService.getAllProjects());
		return "all";
	}
	@GetMapping("/create")
	public String ShowCreateProjectForm(Model model){
		model.addAttribute("project", new Project());
		return "create-new-project";
	}
	@PostMapping("/create")
	public String CreateNewProject(@ModelAttribute Project project, RedirectAttributes redirectAttributes) {
		projectService.createOne(project);
		redirectAttributes.addFlashAttribute("successMessage", "Project created successfully!");
		return "redirect:/admin/dashboard";

	}
	
	@GetMapping("/{id}")
	public String showSelectedProject(@PathVariable Long id, Model model) {
		model.addAttribute("project" ,projectService.getOneProject(id));
		return "project-detail";
	}
	
	@PostMapping("/{id}/delete")
	public String DeleteProject(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		projectService.deleteOne(id);
		redirectAttributes.addFlashAttribute("successMessage", "Project deleted successfully!");
		return "redirect:/admin/dashboard";
	}
	
	
}
	
	
