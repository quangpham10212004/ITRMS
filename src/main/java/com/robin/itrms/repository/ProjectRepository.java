package com.robin.itrms.repository;

import com.robin.itrms.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.robin.itrms.entity.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

    List<Project> findByAdmin(Admin admin);
}
