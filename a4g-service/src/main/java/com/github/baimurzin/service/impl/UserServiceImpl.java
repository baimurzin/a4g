package com.github.baimurzin.service.impl;

import com.github.baimurzin.domain.UserEntity;
import com.github.baimurzin.domain.UserInfoEntity;
import com.github.baimurzin.domain.enums.UserRoles;
import com.github.baimurzin.dto.UserRegistrationForm;
import com.github.baimurzin.repository.UserRepository;
import com.github.baimurzin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vlad on 16.10.15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findByEmailOrLogin(String emailOrLogin) {
        return userRepository.findByLoginOrEmail(emailOrLogin);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UserEntity createUser(UserRegistrationForm userRegistrationForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(userRegistrationForm.getPassword());
        userEntity.setEmail(userRegistrationForm.getEmail());
        userEntity.setLogin(userRegistrationForm.getLogin());
        userEntity.setRole(UserRoles.USER_NOT_CONFIRMED);
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userEntity.setUserInfoEntity(userInfoEntity);
        return userRepository.save(userEntity);
    }
}
