package com.github.baimurzin.security;

import com.github.baimurzin.domain.UserEntity;

/**
 * Created by vlad on 16.10.15.
 */
public interface UserSecurityService {
    UserEntity loadUser(String emailOrLogin);
}
