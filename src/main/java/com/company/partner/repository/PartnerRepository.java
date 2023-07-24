package com.company.partner.repository;

import com.company.partner.entity.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PartnerRepository extends JpaRepository<PartnerEntity, String> {

    Optional<PartnerEntity> findByName(String name);
}