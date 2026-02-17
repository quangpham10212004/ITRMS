package com.robin.itrms.service;

import java.util.List;
import java.util.Optional;

import com.robin.itrms.entity.Admin;
import com.robin.itrms.entity.User;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robin.itrms.entity.Project;
import com.robin.itrms.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository repo;
	
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
		Optional<Project> check  = repo.findById(project.getId());
		if(!check.isPresent()) {
			return repo.save(project);
		}
		else {
			return null;
		}
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
