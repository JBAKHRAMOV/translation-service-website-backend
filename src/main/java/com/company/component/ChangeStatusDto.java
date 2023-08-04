package com.company.component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangeStatusDto {
    @NotNull @NotBlank
    private String id;
    @NotNull @NotBlank
    private ViewStatus status;
}
