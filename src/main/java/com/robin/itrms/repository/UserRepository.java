package com.robin.itrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.robin.itrms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//	public Optional<User> findById(@Param("Id") Long id); ko can vi no co san
	
	public Optional<User> findByUserName(String userName);

	public Optional<User> findByEmail( String email);
}
