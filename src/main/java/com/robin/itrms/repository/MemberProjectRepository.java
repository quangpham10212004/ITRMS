package com.robin.itrms.repository;

import com.robin.itrms.entity.MemberProject;
import com.robin.itrms.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberProjectRepository extends JpaRepository<MemberProject, Long> {
    List<MemberProject> findByProject(Project project);

    boolean existsByMemberIdAndProjectId(Long memberId, Long projectId);
}
