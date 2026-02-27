package com.robin.itrms.service;

import java.util.ArrayList;
import java.util.List;

import com.robin.itrms.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robin.itrms.entity.Task;
import com.robin.itrms.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository repo;
	
	// C
	public Task CreateOne(Task task) {
		return repo.save(task);
	}
	//R
	public List<Task> getAllTasks(){
		return repo.findAll();
	}
	
	public Task GetOneTask(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("No Task Found"));
	}
	
	//U 
	public Task UpdateTask(Task newTask, Long id) {
		return repo.findById(id)
				.map(task->{
					task.setDescription(newTask.getDescription());
					task.setPriority(newTask.getPriority());
					task.setTaskStatus(newTask.getTaskStatus());
					task.setTitle(newTask.getTitle());
					task.setDueDate(newTask.getDueDate());
					task.setMemberProject(newTask.getMemberProject());
					return repo.save(task);
				})
				.orElseThrow(()-> new RuntimeException("Update Failed"));
		
	}

	// D
	public void deleteTask(Long id) {
		repo.deleteById(id);
	}

//	public List<Task> GetTasksInProject(Project project){
//		Long id =  project.getId();
//		List<Task> list = repo.findBy
//	}
}
