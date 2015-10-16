package com.github.baimurzin.service;

import com.github.baimurzin.domain.PhotoEntity;
import com.github.baimurzin.domain.UserInfoEntity;

/**
 * Created by vlad on 16.10.15.
 */
public interface PhotoService {
    PhotoEntity addPhoto(String relativeUrl, UserInfoEntity currentUser);
}
