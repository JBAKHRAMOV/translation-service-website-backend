package com.company.location.dto;

import com.company.component.ViewStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationReqDto {
    private String name;
    private String link;
    private ViewStatus status;
}
