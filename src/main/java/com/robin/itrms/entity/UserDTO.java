package com.robin.itrms.entity;

public class UserDTO {
    private String userName, role, status;
    private Long id;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
