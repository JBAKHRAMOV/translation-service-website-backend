package com.company.contact.entity;

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
@Table(name = "contact_entity")
public class ContactEntity extends EntityBase {
    private String icon;
    private String info;
    @Enumerated(EnumType.STRING)
    private ViewStatus status;
}