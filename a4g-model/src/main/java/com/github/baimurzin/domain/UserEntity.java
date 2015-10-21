package com.github.baimurzin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.baimurzin.domain.enums.UserRoles;

import javax.persistence.*;

/**
 * Created by vlad on 16.10.15.
 */
@Table(name = "USERS")
@Entity
public class UserEntity extends BaseEntity{

    private String email;
    private String login;
    @JsonIgnore
    private String password;
    @OneToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userEntity")
    private UserInfoEntity userInfoEntity;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    @Column(name = "user_id")
    public void setId(long id) {
        super.setId(id);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfoEntity getUserInfoEntity() {
        return userInfoEntity;
    }

    public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}
