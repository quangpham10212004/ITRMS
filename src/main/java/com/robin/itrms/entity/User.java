package com.robin.itrms.entity;

import java.time.LocalDate;

import com.robin.itrms.dto.UserDTO;
import com.robin.itrms.eenum.RoleUser;
import com.robin.itrms.eenum.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
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
	@Enumerated(EnumType.STRING)
	private RoleUser role; // se tinh chinh lai thanh Enum
	@Enumerated(EnumType.STRING)
	private UserStatus status; // cung se tinh chinh lai thanh Enum

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // PK
	
	

	public User(String userName, String password, String email, String phoneNumber, LocalDate dob, RoleUser role,
			UserStatus status) {
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

	public RoleUser getRole() {
		return role;
	}

	public void setRole(RoleUser member) {
		this.role = member;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
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
