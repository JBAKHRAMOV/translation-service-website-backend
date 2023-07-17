package com.company.user.service;

import com.company.base.ResDTO;
import com.company.user.dto.UserDto;
import com.company.user.dto.UserResDTO;
import com.company.user.dto.UserUpdDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    /**
     * ADMIN
     */
    ResDTO addUser(UserDto dto);
    List<UserResDTO> getAll();
    ResDTO block(String userId);
    ResDTO unblock(String userId);
    List<UserResDTO> getAllByStatus(String status);

    /**
     * ADMIN and PUBLISHER
     */

    UserResDTO getById(String id);
    ResDTO delete(String userId);
    ResDTO update(UserUpdDTO dto);

    /**
     * PUBLISHER
     */
    ResDTO attachUpload( MultipartFile file);
    ResDTO attachDelete(String attachId);







}
