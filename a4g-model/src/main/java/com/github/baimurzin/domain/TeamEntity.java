package com.github.baimurzin.domain;

import javax.persistence.*;

/**
 * Created by vlad on 21.10.15.
 */
@Table(name = "TEAMS")
@Entity
public class TeamEntity extends BaseEntity{

    @Column(name = "team_name")
    private String teamName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;

    @OneToOne(mappedBy = "team")
    private TeamInfoEntity teamInfo;

    @ManyToOne
    @JoinColumn(name = "squad_id")
    private SquadEntity teamSquad;

    @Override
    @Column(name = "team_id")
    public void setId(long id) {
        super.setId(id);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public TeamInfoEntity getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(TeamInfoEntity teamInfo) {
        this.teamInfo = teamInfo;
    }

    public SquadEntity getTeamSquad() {
        return teamSquad;
    }

    public void setTeamSquad(SquadEntity teamSquad) {
        this.teamSquad = teamSquad;
    }

}
