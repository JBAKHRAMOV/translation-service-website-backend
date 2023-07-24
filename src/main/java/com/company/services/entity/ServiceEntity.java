package com.company.services.entity;

import com.company.base.EntityBase;
import com.company.component.ViewStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service_entity")
public class ServiceEntity extends EntityBase {
    private String icon;
    private String nameUz;
    private String nameRu;
    private String nameEng;
    private String shortInfoUz;
    private String shortInfoRu;
    private String shortInfoEng;
    private String fullInfoUz;
    private String fullInfoRu;
    private String fullInfoEng;
    @Enumerated(EnumType.STRING)
    private ViewStatus status;
}