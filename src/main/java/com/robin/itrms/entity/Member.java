package com.robin.itrms.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Member extends User{
	
	
	public Member() {
		super();
	}
	
	@OneToMany(mappedBy = "member")
	private List<MemberProject> memberProjects = new ArrayList<MemberProject>();
	
	
}
