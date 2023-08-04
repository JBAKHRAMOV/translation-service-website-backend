package com.company.message.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageReqDto {
    @NotBlank @NotNull
    private String fullName;
    @NotBlank @NotNull
    private String phoneNum;
    @NotBlank @NotNull
    private String email;
    @NotBlank @NotNull
    private String message;
}
