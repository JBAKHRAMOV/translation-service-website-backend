package com.company.language.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageUpdDto {
    @NotBlank @NotNull
    private String id;
    @NotBlank @NotNull
    private String nameUz;
    @NotBlank @NotNull
    private String nameRu;
    @NotBlank @NotNull
    private String nameEng;
}
