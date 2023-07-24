package com.company.component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangeStatusDto {
    private String id;
    private ViewStatus status;
}
