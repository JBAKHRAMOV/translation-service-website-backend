package com.company.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderReqDto {
    @NotBlank @NotNull
    private String fullName;
    @NotBlank @NotNull
    private String phoneNum;
    @NotBlank @NotNull
    private String message;
    @NotBlank @NotNull
    private Integer wordCount;
    @NotBlank @NotNull
    private String serviceId;
    @NotBlank @NotNull
    private String languageIdTo;
    @NotBlank @NotNull
    private String languageIdFrom;
}
