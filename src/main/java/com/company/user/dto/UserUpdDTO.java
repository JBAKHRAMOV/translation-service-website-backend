package com.company.user.dto;

import com.company.user.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdDTO {
    @NotBlank @NotNull
    private String fullName;
    @NotBlank @NotNull
    private String phoneNum;
    @NotBlank @NotNull
    private String password;
    @NotBlank @NotNull
    private UserRole role;
}
