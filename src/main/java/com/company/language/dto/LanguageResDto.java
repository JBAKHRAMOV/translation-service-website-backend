package com.company.language.dto;

import com.company.component.ViewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageResDto {
    private String id;
    private String nameUz;
    private String nameRu;
    private String nameEng;
    private ViewStatus status;
    private LocalDateTime createdDate;
}
