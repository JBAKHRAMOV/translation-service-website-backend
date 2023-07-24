package com.company.language.dto;

import com.company.component.ViewStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageReqDto {
    private String nameUz;
    private String nameRu;
    private String nameEng;
    private ViewStatus status;
}
