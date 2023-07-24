package com.company.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderReqDto {
    private String fullName;
    private String phoneNum;
    private String message;
    private Integer wordCount;
    private String serviceId;
    private String languageIdTo;
    private String languageIdFrom;
}
