package com.company.comment.dto;

import com.company.component.ViewStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentReqDto {
    @NotNull @NotBlank
    private String fullName;
    @NotNull @NotBlank
    private String message;
    @NotNull @NotBlank
    private String serviceId;
}
