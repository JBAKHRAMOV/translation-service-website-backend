package com.company.order.dto;

import com.company.language.dto.LanguageResDto;
import com.company.order.enums.OrderStatus;
import com.company.services.dto.ServiceResDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResDto {
    private String id;
    private String fullName;
    private String phoneNum;
    private String message;
    private Integer wordCount;
    private ServiceResDto service;
    private LanguageResDto languageTo;
    private LanguageResDto languageFrom;
    private OrderStatus status;
    private LocalDateTime createdDate;
}
