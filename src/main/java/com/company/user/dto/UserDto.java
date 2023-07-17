package com.company.user.dto;

import com.company.user.enums.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String fullName;
    private String phoneNum;
    private String password;
    private UserRole role;
}