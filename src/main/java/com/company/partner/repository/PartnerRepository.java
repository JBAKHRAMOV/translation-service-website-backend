package com.company.partner.repository;

import com.company.partner.entity.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<PartnerEntity, String> {
}