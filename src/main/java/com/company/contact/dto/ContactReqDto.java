package com.company.contact.dto;

import com.company.component.ViewStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactReqDto {
    private String icon;
    private String info;
    private ViewStatus status;
}
