package com.company.partner.dto;

import com.company.component.ViewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartnerReqDto {
    private String icon;
    private String name;
    private String link;
    private String status;
}
