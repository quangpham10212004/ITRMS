package com.robin.itrms.service;

import java.util.List;
import java.util.Optional;

import com.robin.itrms.config.SecurityConfig;
import com.robin.itrms.dto.UserDTO;
import com.robin.itrms.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robin.itrms.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository repo;
	@Autowired
	private AdminService adminService;
	// R
	public List<Project> getAllProjects() {
		return repo.findAll();
	}
	
	public Project getOneProject(Long id) {
		Optional<Project> check = repo.findById(id);
		if(check.isPresent()){
			return check.get();
		}
		return null;
	}
	// C
	public Project createOne(Project project) {
		UserDTO currentUser = SecurityConfig.getPrincipal();
		String adminName = currentUser.getUserName();
		Admin admin = adminService.getAdminInfo(adminName);
		project.setAdmin(admin);
		project.setStatus("ACTIVE"); // Set default status to ACTIVE for new projects
		return repo.save(project);

	}
	// U
	public Project updateOne(Project project, Long id) {

	    Project existing = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Project not found"));

	    existing.setName(project.getName());
	    existing.setDescription(project.getDescription());
	    existing.setStatus(project.getStatus());

	    return repo.save(existing);
	}
	
	// D
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}

	// get projects manipulated by an admin
	public List<Project> getProjectsByAdmin(User user){
		if (user instanceof Admin) {
			return repo.findByAdmin((Admin) user);
		}
		return List.of(); // Return empty list if user is not an Admin
	}
}
