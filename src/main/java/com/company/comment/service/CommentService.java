package com.company.comment.service;

import com.company.comment.dto.CommentReqDto;
import com.company.comment.dto.CommentResDto;
import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;

import java.util.List;

public interface CommentService {
    /**
     * ADMIN
     */
    List<CommentResDto> getAll();

    ResDTO changeStatus(ChangeStatusDto dto);

    ResDTO delete(String id);


    /**
     * without security
     */

    ResDTO add(CommentReqDto dto);

    List<CommentResDto> getAllOnlyPublish();
}
