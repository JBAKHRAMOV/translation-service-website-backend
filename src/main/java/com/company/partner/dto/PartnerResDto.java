package com.company.partner.dto;

import com.company.component.ViewStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PartnerResDto {
    private String id;
    private String icon;
    private String name;
    private String link;
    private ViewStatus status;
    private LocalDateTime createdDate;
}
