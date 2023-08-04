package com.company.contact.dto;

import com.company.component.ViewStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactReqDto {
    @NotBlank @NotNull
    private String icon;
    @NotBlank @NotNull
    private String info;
    @NotBlank @NotNull
    private ViewStatus status;
}
