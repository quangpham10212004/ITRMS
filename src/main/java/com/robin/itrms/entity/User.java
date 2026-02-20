package com.robin.itrms.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Column(nullable = false, unique = true)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String phoneNumber;
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
	private String role; // se tinh chinh lai thanh Enum
	private String status; // cung se tinh chinh lai thanh Enum

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // PK
	
	

	public User(String userName, String password, String email, String phoneNumber, LocalDate dob, String role,
			String status) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.role = role;
		this.status = status;
	}

	public User() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void loadFromDTO(UserDTO userDTO){
		this.userName = userDTO.getUserName();
		this.role = userDTO.getRole();
		this.status = userDTO.getStatus();
	}
	
	
}
