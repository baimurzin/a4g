package com.github.baimurzin.security.impl;

import com.github.baimurzin.domain.UserEntity;
import com.github.baimurzin.security.UserSecurityService;
import com.github.baimurzin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vlad on 16.10.15.
 */
@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    private UserService userService;

    @Override
    public UserEntity loadUser(String emailOrLogin) {
        return userService.findByEmailOrLogin(emailOrLogin);
    }
}
