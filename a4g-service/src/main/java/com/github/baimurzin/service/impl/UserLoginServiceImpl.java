package com.github.baimurzin.service.impl;

import com.github.baimurzin.domain.UserEntity;
import com.github.baimurzin.service.UserLoginService;
import com.github.baimurzin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * Created by vlad on 20.10.15.
 */
@Service
public class UserLoginServiceImpl implements UserLoginService{

    @Autowired
    private UserService userService;

    @Override
    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    @Override
    public boolean isCurrentUser(long userId) {
        return getCurrentUser().getId() == userId;
    }

    @Override
    public UserEntity getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findByLogin(user.getUsername());
    }
}
