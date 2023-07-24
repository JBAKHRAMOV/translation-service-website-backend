package com.company.message.service;

import com.company.component.ResDTO;
import com.company.message.dto.MessageReqDto;
import com.company.message.dto.MessageResDto;
import com.company.message.enums.MessageStatus;

import java.util.List;

public interface MessageService {
    /**
     * ADMIN
     */
    List<MessageResDto> getAll();
    List<MessageResDto> getAllByStatus(MessageStatus status);

    ResDTO changeStatus(String id);

    ResDTO delete(String id);


    /**
     * without security
     */

    ResDTO add(MessageReqDto dto);

}
