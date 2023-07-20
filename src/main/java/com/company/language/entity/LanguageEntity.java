package com.company.language.entity;

import com.company.base.EntityBase;
import com.company.component.ViewStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "language_entity")
public class LanguageEntity extends EntityBase {
    private String nameUz;
    private String nameRu;
    private String nameEng;
    private ViewStatus status;
}