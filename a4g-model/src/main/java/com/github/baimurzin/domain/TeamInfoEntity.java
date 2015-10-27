package com.github.baimurzin.domain;

import javax.persistence.*;

/**
 * Created by vlad on 23.10.15.
 */
@Entity
@Table(name = "TEAMS_INFO")
public class TeamInfoEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;
    @OneToOne
    @JoinColumn(name = "photo_id")
    private PhotoEntity teamLogo;

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }

    @Override
    @Column(name = "team_info_id")
    public void setId(long id) {
        super.setId(id);
    }

    public PhotoEntity getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(PhotoEntity teamLogo) {
        this.teamLogo = teamLogo;
    }
}
