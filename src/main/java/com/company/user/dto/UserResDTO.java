package com.company.user.dto;

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
    private String name;
    private String surname;
    private String email;
    private String phoneNum;
    private String password;
    private String attachId;
    private String attachPath;
    private LocalDateTime createdDate;
}
