package com.company.language.repository;

import com.company.language.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<LanguageEntity, String> {

    Optional<LanguageEntity> findByNameEng( String nameEng);
}