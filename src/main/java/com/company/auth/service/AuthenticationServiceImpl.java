package com.company.auth.service;

import com.company.auth.dto.*;
import com.company.component.ResDTO;
import com.company.config.JwtUtil;
import com.company.exp.*;
import com.company.user.entity.UserEntity;
import com.company.user.enums.UserRole;
import com.company.user.enums.UserStatus;
import com.company.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.company.user.enums.UserStatus.ACTIVE;

@Slf4j
@Service("authentication-service")
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public ResDTO register(RegisterRequest request) {

        Optional<UserEntity> optionalUser = repository.findByPhoneNum(request.getPhoneNum());

        if (optionalUser.isPresent()){
            log.warn("User already exists with phone number {}", request.getPhoneNum());
            throw new ItemAlreadyExistsException("User with such a phone already exists");
        }


        UserEntity user = new UserEntity(
                request.getFullName(),
                request.getPhoneNum(),
                passwordEncoder.encode(request.getPassword()),
                "",
                "",
                ACTIVE,
                UserRole.valueOf(request.getRole())
        );
        repository.save(user);
        log.info("Created user : {}", user);

//        var jwtToken = JwtUtil.encode(user.getId());
        return new ResDTO();
    }


    public ResDTO authenticate(AuthenticationRequest request) {

        var user = repository.findByPhoneNum(request.getPhoneNum())
                .orElseThrow(() -> new ItemNotFoundException("Phone is not correct"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            log.warn("Password not correct with thi request : {}", request);
            throw new ItemNotFoundException("Password is not correct");
        }

        if (user.getStatus().equals(UserStatus.BLOCK)
                || user.getStatus().equals(UserStatus.DELETED)) {
            log.warn("User is blocked with phone : {}", request);
            throw new UserBlockException("You blocked by admin");
        }

        var jwtToken = JwtUtil.encode(user.getId());

        return new ResDTO(true, jwtToken);
    }


}
