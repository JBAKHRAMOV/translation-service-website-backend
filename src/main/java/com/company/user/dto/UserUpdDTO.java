package com.company.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdDTO {
    private String name;
    private String surname;
    private String email;
    private String phoneNum;
    private String password;
}
