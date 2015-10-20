package com.github.baimurzin.service;

import com.github.baimurzin.domain.UserEntity;

/**
 * Created by vlad on 20.10.15.
 */
public interface UserLoginService {
    boolean isAuthenticated();
    boolean isCurrentUser(long userId);
    UserEntity getCurrentUser();
}
