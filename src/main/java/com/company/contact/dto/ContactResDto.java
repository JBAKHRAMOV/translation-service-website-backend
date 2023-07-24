package com.company.contact.dto;

import com.company.component.ViewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ContactResDto {
    private String id;
    private String icon;
    private String info;
    private ViewStatus status;
    private LocalDateTime createdDate;
}
