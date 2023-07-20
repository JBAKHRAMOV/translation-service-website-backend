package com.company.user.service;

import com.company.attach.service.AttachService;
import com.company.component.ResDTO;
import com.company.component.UserComponent;
import com.company.config.details.EntityDetails;
import com.company.exp.ItemAlreadyExistsException;
import com.company.exp.ItemNotFoundException;
import com.company.user.dto.UserDto;
import com.company.user.dto.UserResDTO;
import com.company.user.dto.UserUpdDTO;
import com.company.user.entity.UserEntity;
import com.company.user.enums.UserRole;
import com.company.user.enums.UserStatus;
import com.company.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service("user-service")
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AttachService attachService;


    /**
     * ADMIN
     */

    public ResDTO addUser(UserDto dto) {
        UserComponent.checkPhoneNum(dto.getPhoneNum());
        Optional<UserEntity> optional = userRepository.findByPhoneNum(dto.getPhoneNum());
        if (optional.isPresent()) {
            throw new ItemAlreadyExistsException("User already exists with this phone number");
        }

        userRepository.save(
                new UserEntity(
                        dto.getFullName(),
                        dto.getPhoneNum(),
                        dto.getPassword(),
                        "",
                        "",
                        UserStatus.ACTIVE,
                        UserRole.ROLE_PUBLISHER
                )
        );
        return new ResDTO();
    }

    public List<UserResDTO> getAll() {
        return userRepository.findAll().stream()
                .map(this::entityToDto)
                .toList();
    }

    public List<UserResDTO> getAllByStatus(String status) {
        return userRepository.findAllByStatus(UserStatus.valueOf(status)).stream()
                .map(this::entityToDto)
                .toList();
    }

    public ResDTO block(String userId) {
        var user = getUser(userId);
        user.setStatus(UserStatus.BLOCK);
        userRepository.save(user);
        return new ResDTO();
    }

    public ResDTO unblock(String userId) {
        var user = getUser(userId);
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
        return new ResDTO();
    }


    /**
     * ADMIN and PUBLISHER
     */

    public UserResDTO getById(String id) {
        return entityToDto(getUser(id));
    }

    public ResDTO delete(String userId) {
        var user = getUser(userId);
        user.setStatus(UserStatus.DELETED);
        userRepository.save(user);
        return new ResDTO();
    }


    /**
     * USER
     */
    public ResDTO update( String id, UserUpdDTO dto) {

        UserEntity entity = getUser(id);

        UserComponent.checkPhoneNum(dto.getPhoneNum());

        if (!entity.getPhoneNum().equals(dto.getPhoneNum()))
            if (userRepository.findByPhoneNum(dto.getPhoneNum()).isPresent())
                throw new ItemAlreadyExistsException("User already exists with this phone number ");


        entity.setFullName(dto.getFullName());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setPhoneNum(dto.getPhoneNum());
        entity.setRole(dto.getRole());
        userRepository.save(entity);

        return new ResDTO();
    }

    public ResDTO attachUpload(MultipartFile file) {
        var user = getUser(EntityDetails.getProfile().getId());
        var res = attachService.upload(file);
        if (!user.getAttachId().isEmpty()) {
            attachService.delete(user.getAttachId());
        }
        user.setAttachId(res.getId());
        user.setAttachPath(res.getPath());

        userRepository.save(user);
        return new ResDTO();
    }

    public ResDTO attachDelete(String attachId) {
        var user = getUser(EntityDetails.getProfile().getId());
        if (user.getAttachId().isEmpty()) return new ResDTO(false, "User's attach not found!!!");
        if (!user.getAttachId().equals(attachId)) return new ResDTO(false, "User doesn't have attach which this id");

        if (attachService.delete(attachId)) {
            user.setAttachId("");
            user.setAttachPath("");

            userRepository.save(user);
            return new ResDTO();
        }

        return new ResDTO(false, "Fail , try again ");
    }


    /**
     * COMPONENT
     */

    private UserResDTO entityToDto(UserEntity entity) {
        return new UserResDTO(
                entity.getId(),
                entity.getFullName(),
                entity.getPhoneNum(),
                entity.getPassword(),
                entity.getAttachId(),
                entity.getAttachPath(),
                entity.getRole(),
                entity.getStatus(),
                entity.getCreatedDate()
        );
    }

    private UserEntity getUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("User not found!!!"));
    }
}
