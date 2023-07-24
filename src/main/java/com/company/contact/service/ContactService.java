package com.company.contact.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.contact.dto.ContactReqDto;
import com.company.contact.dto.ContactResDto;
import com.company.contact.dto.ContactUpdDto;

import java.util.List;


public interface ContactService {

    ResDTO add(ContactReqDto dto);

    ResDTO update(ContactUpdDto dto);

    ResDTO changeStatus(ChangeStatusDto dto);

    List<ContactResDto> getAll();

    ResDTO delete(String id);

    /**
     * without security
     */

    List<ContactResDto> getAllOnlyPublish();
}
