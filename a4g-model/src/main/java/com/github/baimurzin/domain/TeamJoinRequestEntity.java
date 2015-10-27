package com.github.baimurzin.domain;

import javax.persistence.*;

/**
 * Created by vlad on 23.10.15.
 */
@Table(name = "TEAM_JOIN_REQUESTS")
@Entity
public class TeamJoinRequestEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity toTeam;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity fromUser;

    @Override
    @Column(name = "team_join_request_id")
    public void setId(long id) {
        super.setId(id);
    }

    public TeamEntity getToTeam() {
        return toTeam;
    }

    public void setToTeam(TeamEntity toTeam) {
        this.toTeam = toTeam;
    }

    public UserEntity getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserEntity fromUser) {
        this.fromUser = fromUser;
    }
}
