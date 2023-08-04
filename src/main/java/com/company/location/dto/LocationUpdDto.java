package com.company.location.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationUpdDto {
    @NotBlank @NotNull
    private String id;
    @NotBlank @NotNull
    private String name;
    @NotBlank @NotNull
    private String link;
}
