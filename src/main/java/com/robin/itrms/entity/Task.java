package com.robin.itrms.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String title;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@Column(nullable = false)
	private String taskStatus;
	private String description;
	private String priority;
	private LocalDateTime dueDate;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "IdMemberProject")
	private MemberProject memberProject;    // FK 
	
	public Task(String title, String taskStatus, String description, String priority,
			LocalDateTime dueDate, MemberProject mp) {
		super();
		this.title = title;
		this.memberProject = mp;
		this.taskStatus = taskStatus;
		this.description = description;
		this.priority = priority;
		this.dueDate = dueDate;
		
	}
	
	public Task() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public MemberProject getMemberProject() {
		return memberProject;
	}

	public void setMemberProject(MemberProject memberProject) {
		this.memberProject = memberProject;
	}
	
	
	
}
