package com.company.services.dto;

import com.company.component.ViewStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceReqDto {
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
}
