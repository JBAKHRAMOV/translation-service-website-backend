package com.company.location.dto;

import com.company.component.ViewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class LocationResDto {
    private String id;
    private String name;
    private String link;
    private ViewStatus status;
    private LocalDateTime createdDate;
}
