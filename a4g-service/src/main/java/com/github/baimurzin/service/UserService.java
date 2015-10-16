package com.github.baimurzin.service;

import com.github.baimurzin.domain.UserEntity;
import com.github.baimurzin.dto.UserRegistrationForm;

/**
 * Created by vlad on 16.10.15.
 */
public interface UserService {
    UserEntity findByEmailOrLogin(String emailOrLogin);
    UserEntity findByEmail(String email);
    UserEntity findByLogin(String login);
    UserEntity createUser(UserRegistrationForm userRegistrationForm);
}
