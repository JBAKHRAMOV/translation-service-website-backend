package com.company.attach.repository;


import com.company.attach.entity.AttachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachRepository extends JpaRepository<AttachEntity, String> {
}