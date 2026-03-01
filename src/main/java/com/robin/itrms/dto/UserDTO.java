package com.robin.itrms.dto;

import com.robin.itrms.eenum.RoleUser;
import com.robin.itrms.eenum.UserStatus;
import com.robin.itrms.entity.User;
import org.springframework.context.annotation.Bean;


public class UserDTO {
    private String userName;
    private Long id;
    private RoleUser role;
    private UserStatus status;
    public void loadFromEntity(User user){
        this.userName = user.getUserName();
        this.role = user.getRole();
        this.status = user.getStatus();
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
