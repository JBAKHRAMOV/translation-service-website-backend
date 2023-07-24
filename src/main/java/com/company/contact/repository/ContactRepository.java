package com.company.contact.repository;

import com.company.contact.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<ContactEntity, String> {
    Optional<ContactEntity> findByInfo(String info);
}