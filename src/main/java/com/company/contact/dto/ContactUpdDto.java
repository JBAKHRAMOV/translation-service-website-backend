package com.company.contact.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactUpdDto {
    @NotBlank @NotNull
    private String id;
    @NotBlank @NotNull
    private String icon;
    @NotBlank @NotNull
    private String info;
}
