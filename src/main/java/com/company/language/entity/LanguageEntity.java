package com.company.language.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "language_entity")
public class LanguageEntity extends EntityBase {
    private String nameUz;
    private String nameRu;
    private String nameEng;
    @Enumerated(EnumType.STRING)
    private ViewStatus status;
}