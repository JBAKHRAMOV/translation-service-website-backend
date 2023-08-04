package com.company.language.dto;

import com.company.component.ViewStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageReqDto {
    @NotBlank @NotNull
    private String nameUz;
    @NotBlank @NotNull
    private String nameRu;
    @NotBlank @NotNull
    private String nameEng;
    @NotBlank @NotNull
    private ViewStatus status;
}
