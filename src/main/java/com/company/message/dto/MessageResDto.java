package com.company.message.dto;

import com.company.component.ViewStatus;
import com.company.message.enums.MessageStatus;
import com.company.services.dto.ServiceResDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class MessageResDto {
    private String id;
    private String fullName;
    private String phoneNum;
    private String email;
    private String message;
    private MessageStatus status;
    private LocalDateTime createdDate;
}
