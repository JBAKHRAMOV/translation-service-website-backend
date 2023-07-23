package com.company.partner.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.language.dto.LanguageReqDto;
import com.company.language.dto.LanguageResDto;
import com.company.language.dto.LanguageUpdDto;
import com.company.partner.dto.PartnerReqDto;
import com.company.partner.dto.PartnerResDto;
import com.company.partner.dto.PartnerUpdDto;

import java.util.List;

public interface PartnerService {
    /**
     * ADMIN
     */

    ResDTO add(PartnerReqDto dto);
    ResDTO update(String id, PartnerUpdDto dto);
    ResDTO changeStatus(ChangeStatusDto dto);
    List<PartnerResDto> getAll();

    /**
     * without security
     */

    List<PartnerResDto> getAllOnlyPublish();
}
