package com.robin.itrms.service;

import com.robin.itrms.entity.Member;
import com.robin.itrms.entity.MemberProject;
import com.robin.itrms.entity.Project;
import com.robin.itrms.entity.Task;
import com.robin.itrms.entity.User;
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
        User user = userRepository.findById(memberId).orElseThrow(()->
                new RuntimeException("Member Not Found"));
        
        Project project = projectRepository.findById(projectId).orElseThrow(()->
                new RuntimeException("Project Not Found"));
        boolean exist = repo.existsByMemberIdAndProjectId(memberId, projectId);
        if(exist){
            throw new RuntimeException("Member Already In Project");
        }
        if(!(user instanceof Member)) {
            throw new RuntimeException("User with ID " + memberId + " is not a Member (could be an Admin)");
        }
        Member member = (Member) user;

        MemberProject mp = new  MemberProject();
        mp.setMember(member);
        mp.setProject(project);
        repo.save(mp);
    }

    // D
    public void DeleteMemberProject(MemberProject memberProject) {
        repo.delete(memberProject);
    }

    public void RemoveMemberProject(Long mpId) {
        repo.deleteById(mpId);
    }

    public MemberProject GetOneMP(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found"));
    }
}
