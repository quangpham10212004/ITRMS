package com.robin.itrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.robin.itrms.eenum.RoleUser;
import com.robin.itrms.eenum.UserStatus;
import com.robin.itrms.entity.Member;
import com.robin.itrms.entity.User;
import com.robin.itrms.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Member CreateNewMember(User user) {
		Member member = new Member();
		member.setUserName(user.getUserName());
		member.setEmail(user.getEmail());
		member.setId(user.getId());
		member.setDob(user.getDob());
		member.setPassword(passwordEncoder.encode(user.getPassword()));
		member.setRole(RoleUser.MEMBER);
		member.setStatus(UserStatus.ACTIVE);
		member.setPhoneNumber(user.getPhoneNumber());
		
		return repo.save(member);
	}
}
