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
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String name;
	private String description;
	@Column(nullable = false)
	private String status;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="IdAdmin")
	private Admin admin;
	
	public Project() {
		
	}
	public Project(String name, String description, String status, LocalDateTime createdAt,
			LocalDateTime updatedAt, Admin admin) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Admin getAdmin() {
		return admin;
	}
	
}
