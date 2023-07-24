package com.company.social_media.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.social_media.dto.SocialMediaReqDto;
import com.company.social_media.dto.SocialMediaResDto;
import com.company.social_media.dto.SocialMediaUpdDto;

import java.util.List;


public interface SocialMediaService {

    ResDTO add(SocialMediaReqDto dto);

    ResDTO update(SocialMediaUpdDto dto);

    ResDTO changeStatus(ChangeStatusDto dto);

    List<SocialMediaResDto> getAll();

    ResDTO delete(String id);

    /**
     * without security
     */

    List<SocialMediaResDto> getAllOnlyPublish();
}
