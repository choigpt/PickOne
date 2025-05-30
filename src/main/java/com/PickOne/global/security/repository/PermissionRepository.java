package com.PickOne.global.security.repository;

import com.PickOne.global.security.model.domain.Category;
import com.PickOne.global.security.model.domain.PermissionCode;
import com.PickOne.global.security.model.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface
PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    Optional<PermissionEntity> findByCode(PermissionCode code);
    List<PermissionEntity> findByCategory(Category category);
}