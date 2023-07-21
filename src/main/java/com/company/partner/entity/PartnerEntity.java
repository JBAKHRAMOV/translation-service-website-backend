package com.company.partner.entity;

import com.company.base.EntityBase;
import com.company.component.ViewStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "partner_entity")
public class PartnerEntity extends EntityBase {
    private String icon;
    private String name;
    private String link;
    @Enumerated(EnumType.STRING)
    private ViewStatus status;
}