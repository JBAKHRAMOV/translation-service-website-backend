package com.company.order.entity;

import com.company.base.EntityBase;
import com.company.component.ViewStatus;
import com.company.language.entity.LanguageEntity;
import com.company.order.enums.OrderStatus;
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
@Table(name = "order_entity")
public class OrderEntity extends EntityBase {

    private String fullName;
    private String phoneNum;
    private String message;
    private Integer wordCount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "service_id", nullable = false)
    private String serviceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private ServiceEntity service;

    @Column(name = "language_id_to", nullable = false)
    private String languageIdTo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id_to", insertable = false, updatable = false)
    private LanguageEntity languageTo;

    @Column(name = "language_id_from", nullable = false)
    private String languageIdFrom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id_from", insertable = false, updatable = false)
    private LanguageEntity languageFrom;
}