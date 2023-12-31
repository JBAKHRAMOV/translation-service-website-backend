package com.company.language.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.language.dto.LanguageReqDto;
import com.company.language.dto.LanguageResDto;
import com.company.language.dto.LanguageUpdDto;
import com.company.language.entity.LanguageEntity;

import java.util.List;

public interface LanguageService {
    /**
     * ADMIN
     */

    ResDTO add(LanguageReqDto dto);
    ResDTO update(LanguageUpdDto dto);
    ResDTO changeStatus(ChangeStatusDto dto);
    List<LanguageResDto> getAll();

    /**
     * without security
     */

    List<LanguageResDto> getAllOnlyPublish();

    /**
     * COMPONENT
     */

    LanguageEntity getById(String id);

    LanguageResDto entityToDto(LanguageEntity entity);
}
