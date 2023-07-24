package com.company.comment.dto;

import com.company.component.ViewStatus;
import com.company.services.dto.ServiceResDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResDto {
    private String id;
    private String fullName;
    private String message;
    private ServiceResDto service;
    private ViewStatus status;
    private LocalDateTime createdDate;
}
