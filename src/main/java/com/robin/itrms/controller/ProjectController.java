package com.robin.itrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robin.itrms.entity.Project;
import com.robin.itrms.service.ProjectService;


@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping("")
	public List<Project> showAllProjects(){
		return projectService.getAllProjects();
	}
	@PostMapping("")
	public Project AddNewProject(@RequestBody Project project) {
		return projectService.createOne(project);
	}
	
	@GetMapping("/{id}")
	public Project showSelectedProject(@PathVariable Long id) {
		return projectService.getOneProject(id);
	}
	
	@DeleteMapping("/{id}")
	public void DeleteProject(@PathVariable Long id) {
		projectService.deleteOne(id);
	}
	
	
}
	
	
