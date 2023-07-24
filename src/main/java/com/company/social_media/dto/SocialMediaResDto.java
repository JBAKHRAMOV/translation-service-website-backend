package com.company.social_media.dto;

import com.company.component.ViewStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class SocialMediaResDto {
    private String id;
    private String icon;
    private String name;
    private String link;
    private ViewStatus status;
    private LocalDateTime createdDate;
}
