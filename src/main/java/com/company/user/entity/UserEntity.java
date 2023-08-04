package com.company.user.entity;

import com.company.base.EntityBase;
import com.company.user.enums.UserRole;
import com.company.user.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
public class UserEntity  extends EntityBase {

    @Size(message = "Full name size is not valid. Full name must be longer than 7 letters " , min = 7)
    @NotBlank(message = "full name is blank")
    @NotEmpty(message = "full name is empty")
    @NotNull(message = "full name is null")
    @Column
    private String fullName;

    @Size(message = "Phone size is not valid. Phone must be longer than 7 letters and less than 13 letters " , min = 9, max = 13)
    @NotBlank(message = "phone is blank")
    @NotEmpty(message = "phone is empty")
    @NotNull(message = "phone is null")
    @Column(unique = true)
    private String phoneNum;

    @Size(message = "Password size is not valid. Password must be longer than 5 letters" , min = 5)
    @NotBlank(message = "password is blank")
    @NotEmpty(message = "password is empty")
    @NotNull(message = "password is null")
    private String password;

    private String attachId;

    private String attachPath;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}