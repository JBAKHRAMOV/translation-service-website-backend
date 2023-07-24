package com.company.social_media.repository;

import com.company.social_media.entity.SocialMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialMediaRepository extends JpaRepository<SocialMediaEntity, String> {
    Optional<SocialMediaEntity> findByName(String name);
}