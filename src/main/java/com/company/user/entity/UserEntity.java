package com.company.user.entity;

import com.company.base.EntityBase;
import com.company.user.enums.UserRole;
import com.company.user.enums.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_entity")
public class UserEntity  extends EntityBase {
    private String name;
    private String surname;
    private String email;
    private String phoneNum;
    private String password;
    private String attachId;
    private String attachPath;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean isConfirm;
    private Boolean isBlock;
    private LocalDate paymentDate;



}