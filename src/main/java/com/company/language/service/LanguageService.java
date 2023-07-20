package com.company.language.service;

import com.company.component.ResDTO;
import com.company.language.dto.LanguageReqDto;
import com.company.language.dto.LanguageResDto;

import java.util.List;

public interface LanguageService {
    /**
     * ADMIN
     */

    ResDTO add(LanguageReqDto dto);
    ResDTO update(String id, LanguageReqDto dto);
    ResDTO changeStatus(String id);
    List<LanguageResDto> getAll();

    /**
     * USER
     */

    List<LanguageResDto> getAllOnlyPublish();
}
