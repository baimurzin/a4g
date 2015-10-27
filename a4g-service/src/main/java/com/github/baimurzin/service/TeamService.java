package com.github.baimurzin.service;

import com.github.baimurzin.domain.TeamEntity;
import com.github.baimurzin.domain.TeamJoinRequestEntity;
import com.github.baimurzin.domain.UserEntity;
import com.github.baimurzin.dto.TeamCreationDTO;

import java.util.List;

/**
 * Created by vlad on 21.10.15.
 */
public interface TeamService {
    TeamEntity createTeam(TeamCreationDTO teamCreationDTO);
    List<TeamEntity> allTeam();
    TeamEntity findTeamByName(String name);
    boolean leaveTeam(TeamEntity teamEntity, UserEntity userEntity);
    boolean acceptRequest(TeamJoinRequestEntity joinRequest);
    boolean sendJoinRequest(TeamEntity toTeam, UserEntity fromUser);
    List<TeamJoinRequestEntity> getAllRequestForTeam(TeamEntity forTeam);
    boolean declineJoinRequest(TeamJoinRequestEntity joinRequest);

}
