package com.company.social_media.entity;

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
@Table(name = "social_media_entity")
public class SocialMediaEntity extends EntityBase {
    private String icon;
    private String name;
    private String link;
    @Enumerated(EnumType.STRING)
    private ViewStatus status;
}