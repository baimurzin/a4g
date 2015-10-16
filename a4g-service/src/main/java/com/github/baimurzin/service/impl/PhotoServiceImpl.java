package com.github.baimurzin.service.impl;

import com.github.baimurzin.domain.PhotoEntity;
import com.github.baimurzin.domain.UserInfoEntity;
import com.github.baimurzin.repository.PhotoRepository;
import com.github.baimurzin.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vlad on 16.10.15.
 */
@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    public PhotoEntity addPhoto(String relativeUrl, UserInfoEntity currentUser) {
        PhotoEntity photo = new PhotoEntity();
        photo.setOwner(currentUser);
        photo.setPhotoPath(relativeUrl);
        return photoRepository.save(photo);
    }
}
