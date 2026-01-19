package com.robin.itrms.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Admin extends User{
	public Admin() {
		super();
	}
	@OneToMany(mappedBy = "admin")
	private  List<Project> projects = new ArrayList<Project>();
}
