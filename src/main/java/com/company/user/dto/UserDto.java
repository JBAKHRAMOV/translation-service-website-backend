package com.company.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ParametrObject
public class UserDto {
    private String name;
    private String surname;
    private String email;

//    Pattern()
    private String phoneNum;
    private String password;
}