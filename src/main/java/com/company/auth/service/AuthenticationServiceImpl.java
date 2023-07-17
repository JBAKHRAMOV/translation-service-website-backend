package com.company.auth.service;

import com.company.auth.dto.*;
import com.company.base.ResDTO;
import com.company.component.UserComponent;
import com.company.config.JwtUtil;
import com.company.exp.*;
import com.company.user.entity.UserEntity;
import com.company.user.enums.UserStatus;
import com.company.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static com.company.user.enums.UserRole.ROLE_USER;
import static com.company.user.enums.UserStatus.NOT_ACTIVE;

@Service("authentication-service")
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public ResDTO register(RegisterRequest request) {

        UserComponent.checkPhoneNum(request.getPhone());

        Optional<UserEntity> optionalUser = repository.findByPhoneNum(request.getPhone());

        if (optionalUser.isPresent()) {
            UserEntity entity = optionalUser.get();
            if (entity.getIsConfirm()) {
                throw new ItemAlreadyExistsException("User with such a phone already exists");
            } else {
                repository.deleteById(entity.getId());
            }
        }

        UserEntity user = new UserEntity(
                request.getName(),
                request.getSurname(),
                request.getEmail(),
                request.getPhone(),
                passwordEncoder.encode(request.getPassword()),
                "",
                "",
                NOT_ACTIVE,
                ROLE_USER,
                false,
                false,
                LocalDate.now()
        );
        repository.save(user);

        var jwtToken = JwtUtil.encode(user.getId());
        return new ResDTO(true, jwtToken);
    }


    public ResDTO authenticate(AuthenticationRequest request) {

        UserComponent.checkPhoneNum(request.getPhone());

        var user = repository.findByPhoneNumAndIsConfirm(request.getPhone(), true)
                .orElseThrow(() -> new ItemNotFoundException("User not found"));

        if (user.getPassword().equals(passwordEncoder.encode(request.getPassword()))) {
            throw new PasswordNotCorrectException("Password not correct");
        }
        if (user.getIsBlock()) {
            throw new UserBlockException("This user blocked by admin");
        }
        if (user.getStatus().equals(UserStatus.UNPAID)) {
            throw new UnpaidException("Money unpaid");
        }

        user.setStatus(UserStatus.ACTIVE);
        repository.save(user);

        var jwtToken = JwtUtil.encode(user.getId());

        return new ResDTO(true, jwtToken);
    }


}
