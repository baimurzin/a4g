package com.github.baimurzin.domain;

import javax.persistence.*;

/**
 * Created by vlad on 16.10.15.
 */
@Table(name = "PHOTOS")
@Entity
public class PhotoEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_info_id", nullable = false)
    private UserInfoEntity owner;

    @Column(name = "photo_path")
    private String photoPath;

    public PhotoEntity() {
    }

    public PhotoEntity(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    @Column(name = "photo_id")
    public void setId(long id) {
        super.setId(id);
    }

    public UserInfoEntity getOwner() {
        return owner;
    }

    public void setOwner(UserInfoEntity owner) {
        this.owner = owner;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
