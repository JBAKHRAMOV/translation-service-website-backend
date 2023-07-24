package com.company.message.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageReqDto {
    private String fullName;
    private String phoneNum;
    private String email;
    private String message;
}
