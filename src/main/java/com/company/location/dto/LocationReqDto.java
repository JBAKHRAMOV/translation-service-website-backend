package com.company.location.dto;

import com.company.component.ViewStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationReqDto {
    @NotBlank @NotNull
    private String name;
    @NotBlank @NotNull
    private String link;
    @NotBlank @NotNull
    private ViewStatus status;
}
