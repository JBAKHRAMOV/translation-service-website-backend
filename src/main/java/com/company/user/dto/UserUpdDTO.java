package com.company.user.dto;

import com.company.user.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdDTO {
    private String fullName;
    private String phoneNum;
    private String password;
    private UserRole role;
}
