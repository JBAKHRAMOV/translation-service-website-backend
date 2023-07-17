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
    ResDTO addUser(UserDto dto); // admin
    List<UserResDTO> getAll();// admin
    ResDTO block(String userId);// admin
    ResDTO unblock(String userId);// admin
    List<UserResDTO> getAllByStatus(String status);// admin

    /**
     * ADMIN and USER
     */

    UserResDTO getById(String id);// user and admin
    ResDTO delete(String userId);// user and admin


    /**
     * USER
     */

    ResDTO update(UserUpdDTO dto);// user
    ResDTO attachUpload( MultipartFile file);// user
    ResDTO attachDelete(String attachId);// user
    UserResDTO confirmUser(String userId);// user







}
