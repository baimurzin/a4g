package com.github.baimurzin.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by vlad on 21.10.15.
 */
@Table(name = "SQUADS")
@Entity
public class SquadEntity extends BaseEntity {

    @OneToMany
    private Set<UserEntity> user;

    @Override
    @Column(name = "squad_id")
    public void setId(long id) {
        super.setId(id);
    }

    public Set<UserEntity> getUser() {
        return user;
    }

    public void setUser(Set<UserEntity> user) {
        this.user = user;
    }
}
