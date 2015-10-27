package com.github.baimurzin.repository;

import com.github.baimurzin.domain.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 23.10.15.
 */
@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

}
