package com.company.location.entity;

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
@Table(name = "location_entity")
public class LocationEntity extends EntityBase {
    private String name;
    private String link;
    @Enumerated(EnumType.STRING)
    private ViewStatus status;
}