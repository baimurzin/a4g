package com.github.baimurzin.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vlad on 16.10.15.
 */
@Table(name = "USERS_INFO")
@Entity
public class UserInfoEntity extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;
    private String city;
    @Column(name = "last_activity")
    private Date lastActivity;
    @Column(name = "about_me")
    private String aboutMe;
    @OneToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "photo_id")
    private PhotoEntity profilePhoto;

    public UserInfoEntity() {
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    @Column(name = "user_info_id")
    public void setId(long id) {
        super.setId(id);
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public PhotoEntity getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(PhotoEntity profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
