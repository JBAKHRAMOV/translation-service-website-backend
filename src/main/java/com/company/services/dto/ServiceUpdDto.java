package com.company.services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceUpdDto {

    @NotBlank @NotNull
    private String id;
    @NotBlank @NotNull
    private String icon;
    @NotBlank @NotNull
    private String nameUz;
    @NotBlank @NotNull
    private String nameRu;
    @NotBlank @NotNull
    private String nameEng;
    @NotBlank @NotNull
    private String shortInfoUz;
    @NotBlank @NotNull
    private String shortInfoRu;
    @NotBlank @NotNull
    private String shortInfoEng;
    @NotBlank @NotNull
    private String fullInfoUz;
    @NotBlank @NotNull
    private String fullInfoRu;
    @NotBlank @NotNull
    private String fullInfoEng;

}
