package com.company.comment.entity;

import com.company.base.EntityBase;
import com.company.component.ViewStatus;
import com.company.services.entity.ServiceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment_entity")
public class CommentEntity extends EntityBase {

    private String fullName;
    private String message;

    @Column(name = "service_id", nullable = false)
    private String serviceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private ServiceEntity service;

    @Enumerated(EnumType.STRING)
    private ViewStatus status;
}