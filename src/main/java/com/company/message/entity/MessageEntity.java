package com.company.message.entity;

import com.company.base.EntityBase;
import com.company.component.ViewStatus;
import com.company.message.enums.MessageStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message_entity")
public class MessageEntity extends EntityBase {

    private String fullName;
    private String phoneNum;
    private String email;
    private String message;

    @Enumerated(EnumType.STRING)
    private MessageStatus status;
}