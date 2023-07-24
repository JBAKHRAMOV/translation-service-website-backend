package com.company.location.repository;

import com.company.location.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoactionRepository extends JpaRepository<LocationEntity, String> {
    Optional<LocationEntity> findByName(String name);
}