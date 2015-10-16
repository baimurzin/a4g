package com.github.baimurzin.security.impl;

import com.github.baimurzin.domain.UserEntity;
import com.github.baimurzin.security.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlad on 16.10.15.
 */
@Service
public class UserDetailsSecurityServiceImpl implements UserDetailsService{

    @Autowired
    private UserSecurityService securityService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = securityService.loadUser(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(userEntity.getRole().name()));

        return new User(userEntity.getLogin(), userEntity.getPassword(), roles);
    }
}
