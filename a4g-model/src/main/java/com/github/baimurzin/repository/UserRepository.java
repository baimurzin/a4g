package com.github.baimurzin.repository;

import com.github.baimurzin.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 16.10.15.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("from UserEntity u where u.login = ?1 or u.email = ?1")
    UserEntity findByLoginOrEmail(String loginOrEmail);

    @Query("from UserEntity u where u.login = ?1")
    UserEntity findByLogin(String login);

    @Query("from UserEntity u where u.email = ?1")
    UserEntity findByEmail(String email);
}
