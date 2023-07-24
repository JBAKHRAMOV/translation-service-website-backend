package com.company.comment.dto;

import com.company.component.ViewStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentReqDto {
    private String fullName;
    private String message;
    private String serviceId;
}
