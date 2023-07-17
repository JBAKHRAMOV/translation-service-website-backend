package com.company.user.dto;

import com.company.user.enums.UserRole;
import com.company.user.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResDTO {
    private String id;
    private String fullName;
    private String phoneNum;
    private String password;
    private String attachId;
    private String attachPath;
    private UserRole role;
    private UserStatus status;
    private LocalDateTime createdDate;
}
