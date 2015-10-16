package com.github.baimurzin.repository;

import com.github.baimurzin.domain.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 16.10.15.
 */
@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
}
