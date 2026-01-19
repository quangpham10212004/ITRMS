package com.robin.itrms.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MemberProject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // PK
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime joinAt;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="IdMember")
	private Member member;
	
	@OneToMany(mappedBy = "memberProject") // map sang ben kia 
	private List<Task> tasks = new ArrayList<Task>(); 
	
	@ManyToOne(optional = false)
	@JoinColumn(name="IdProject")
	private Project project;
	
	
	public MemberProject(Member member, List<Task> tasks, Project project) {
		super();
		this.member = member;
		this.tasks = tasks;
		this.project = project;
	}
	public MemberProject() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getJoinAt() {
		return joinAt;
	}
	public void setJoinAt(LocalDateTime joinAt) {
		this.joinAt = joinAt;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public List<Task> getTask() {
		return tasks;
	}
	public void setTask(List<Task> task) {
		this.tasks = task;
	}
	
}