package com.company.social_media.dto;

import com.company.component.ViewStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialMediaReqDto {
    private String icon;
    private String name;
    private String link;
    private ViewStatus status;
}
