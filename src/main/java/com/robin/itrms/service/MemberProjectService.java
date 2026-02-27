package com.robin.itrms.service;

import com.robin.itrms.entity.Member;
import com.robin.itrms.entity.MemberProject;
import com.robin.itrms.entity.Project;
import com.robin.itrms.entity.Task;
import com.robin.itrms.repository.MemberProjectRepository;
import com.robin.itrms.repository.ProjectRepository;
import com.robin.itrms.repository.TaskRepository;
import com.robin.itrms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberProjectService {
    @Autowired
    private MemberProjectRepository repo;

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    // R
    public List<MemberProject> GetMPsByProject(Project project) {
        return repo.findByProject(project);
    }
    // C
    public void AddMemberProject(Long memberId, Long projectId) {
        Member member = (Member) userRepository.findById(memberId).orElseThrow(()->
                new RuntimeException("Member Not Found"));
        Project project = projectRepository.findById(projectId).orElseThrow(()->
                new RuntimeException("Project Not Found"));
        boolean exist = repo.existsByMemberIdAndProjectId(memberId, projectId);
        if(exist){
            throw new RuntimeException("Member Already In Project");
        }
        MemberProject mp = new  MemberProject();
        mp.setMember(member);
        mp.setProject(project);
        repo.save(mp);
    }

    // D
    public void DeleteMemberProject(MemberProject memberProject) {
        repo.delete(memberProject);
    }

}
