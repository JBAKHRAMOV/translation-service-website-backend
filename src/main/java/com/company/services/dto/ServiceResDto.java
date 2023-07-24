package com.company.services.dto;

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
public class ServiceResDto {
    private String id;
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
    private ViewStatus status;
    private LocalDateTime createdDate;
}
